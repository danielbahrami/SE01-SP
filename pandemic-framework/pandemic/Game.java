package pandemic;
import java.util.ArrayList;
import java.util.HashMap;

public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Inventory inventory;
    private HashMap<String, Item> itemList = new HashMap<String, Item>();

    public Game()
    {
        createRooms();
        this.parser = new Parser();
        this.inventory = new Inventory();
    }


    private void createRooms()
    {
         Room lobby, reception, pharmacy, southHallway, lounge, cafeteria, midHallway, toilet, northHallway, office, secretRoom;

        lobby = new Room("You are standing in the lobby", 0);
        reception = new Room("the reception, and behind the desk there is a receptionist named ", 1);
        pharmacy = new Room("the pharmacy, and you see an item (paracetamol) on the counter", 2);
        southHallway = new Room("south hallway, and you can see an item (handsanitizer) on the table", 3);
        lounge = new Room("a beautiful lounge and you can see an item (plant)", 4);
        cafeteria = new Room("the cafeteria, and you can see an item (citronmåne) ", 5);
        midHallway = new Room("the middle of the hallway, you see an item (mask) on a small table", 6);
        toilet = new Room("the toilet where you can see an item (soap) ", 7);
        northHallway = new Room("north hallway and you see a person ", 8);
        office = new Room("an office and you see a person ", 9);
        secretRoom = new Room("the secret room, where you can see an item (Manager)", 10);

        lobby.setExit("left", reception);

        reception.setExit("right", lobby);
        reception.setExit("up", lounge);
        reception.setExit("left", pharmacy);

        pharmacy.setExit("right", reception);
        pharmacy.setExit("up", cafeteria);

        southHallway.setExit("left", lounge);
        southHallway.setExit("up", midHallway);

        lounge.setExit("down", reception);
        lounge.setExit("right", southHallway);
        lounge.setExit("left", cafeteria);

        cafeteria.setExit("down", pharmacy);
        cafeteria.setExit("right", lounge);
        cafeteria.setExit("up", toilet);

        midHallway.setExit("up", northHallway);
        midHallway.setExit("down", southHallway);

        toilet.setExit("down", cafeteria);
        toilet.setExit("up", secretRoom);

        northHallway.setExit("down", midHallway);
        northHallway.setExit("left", office);

        office.setExit("right", northHallway);

        secretRoom.setExit("down", toilet);


        // roomNumber.addItemToRoom(< nameOfItem >, < itemDescription >;

        Item para = new Item ("paracetamol", "paracetamol to treat pain and fever", "item");
        pharmacy.addItemToRoom(para);
        Item soap = new Item("soap", "soap to wash your hands", "item");
        pharmacy.addItemToRoom(soap);
        Item handsanitizer = new Item ("handsanitizer", "handsanitizer to disinfect your hands", "food");
        southHallway.addItemToRoom(handsanitizer);
        Item inhaler = new Item("inhaler", "an inhaler to lung patients", "item");
        office.addItemToRoom(inhaler);
        Item manager = new Item("manager", "a manager to satisfy Karen", "item");
        secretRoom.addItemToRoom(manager);
        Item lemoncake = new Item("lemoncake", "a delicious cake made by Dan Cake", "food");
        cafeteria.addItemToRoom(lemoncake);
        Item plant = new Item("plant", "a beautiful plant from plantorama", "item");
        lounge.addItemToRoom(plant);
        Item mask = new Item("mask", "a mask to protect your face", "item");
        midHallway.addItemToRoom(mask);

        this.itemList.put(para.getName(), para);
        this.itemList.put(soap.getName(), soap);
        this.itemList.put(handsanitizer.getName(), handsanitizer);
        this.itemList.put(inhaler.getName(), inhaler);
        this.itemList.put(manager.getName(), inhaler);
        this.itemList.put(lemoncake.getName(), lemoncake);
        this.itemList.put(plant.getName(), plant);
        this.itemList.put(mask.getName(), mask);


        // roomNumber.addNPCToRoom(< NPCName >, < quest >, < questItem >)
        reception.addNPCToRoom("Bo", "I need a mask", new Item("mask", "a mask to protect your face", "item"));
        office.addNPCToRoom("Karen", "I need to talk to the manager", new Item("manager", "a manager to satisfy Karen", "item"));
        northHallway.addNPCToRoom("Flemming", "I need my inhaler", new Item("inhaler","an inhaler to lung patients", "item"));

        currentRoom = lobby;
    }

    public void addItems(Item item)
    {
        this.itemList.put(item.getName(), item);
    }

    public void play()
    {
        printWelcome();


        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Good bye!");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Pandemic Prevention!");
        System.out.println("A virus has spread throughout the world and you must stop the dispersion.\nIn the beginning you'll have to cure the residents of a nursing home.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println("You have entered the nursing home.");
        System.out.println(currentRoom.getShortDescription());
    }

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.TAKE)
        {
            pickUp(command);
        }
        else if (commandWord == CommandWord.USE)
        {
            useItem(command);
        }
        else if (commandWord == CommandWord.GIVE)
        {
            giveItem(command);
        }
        else if (commandWord == CommandWord.INVENTORY)
        {
            showInventory(command);
        }
        else if (commandWord == CommandWord.UNLOCK)
        {
            unlockRoom(command);
        }
        else if (commandWord == CommandWord.TALK)
        {
            talkNPC(command);
        }
        else if (commandWord == CommandWord.DROP)
        {
            dropItem(command);
        }
        else if (commandWord == CommandWord.EAT)
        {
            eatFood(command);
            if (command.getSecondWord().equals("handsanitizer")){
                wantToQuit = true;
            }
        }
        else if (commandWord == CommandWord.EXAMINE)
        {
            examine(command);
        }
        return wantToQuit;
    }

    private void printHelp()
    {
        System.out.println("Your objective is to cure the deceased people in the nursing home.");
        System.out.println("By looking around the rooms, you'll be able to find several objects.");
        System.out.println("Talking to the people may give you an idea of how to cure them");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    public void pickUp(Command command)
    {
        if (!command.hasSecondWord())
        {
            System.out.println("Take what?");
            return;
        }

        ArrayList<Item> itemArray = currentRoom.getItemInRoom();
        for (Item i : itemArray)
        {
            try {
                if (command.getSecondWord().equals(i.getName())) {
                    inventory.addToInventory(i);
                    System.out.println("You took " + i.getName());
                    currentRoom.removeItemFromRoom(i.getName()); //vi kunne break den her
                }
            } catch (NullPointerException e)
            {
                System.out.println("There is no " + command.getSecondWord() + " in the room");
            }
        }

    }

    private void useItem(Command command)
    {

    }

    public void showInventory(Command command)
    {
        if (command.hasSecondWord())
        {
            System.out.println("Invalid command, only one word");
            return;
        }
        else
        {
            inventory.printInventory();
            System.out.println();
        }
    }


    public void giveItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Give what?");
            return;
        }

        try
        {
            Item item = currentRoom.getNPCInRoom().getQuestItem();
            Item questItem;

            if (command.getSecondWord().equals(currentRoom.getNPCInRoom().getQuestItem().getName()))
            {
                System.out.println("Gave " + item.getName() + " to " + currentRoom.getNPCInRoom().getName()
                        + "\nQuest complete!");

                if (this.itemList.containsKey(command.getSecondWord()))
                {
                    questItem = itemList.get(command.getSecondWord());

                    if (this.inventory.isInInventory(questItem))
                    {
                        this.inventory.removeFromInventory(questItem);
                    }
                }
                else
                {
                    System.out.println("You don't have that item.");
                }
            }
            else
            {
                System.out.println("I don't need that.");
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("No one is in the room.");
        }
    }

    private void dropItem(Command command)
    {
        Item item = null;
        if (!command.hasSecondWord())
        {
            System.out.println("Drop what?");
        }
        if (itemList.containsKey(command.getSecondWord()))
        {
            item = itemList.get(command.getSecondWord());
        }
        if (inventory.isInInventory(item))
        {
            inventory.removeFromInventory(item);
            System.out.println("Dropped " + item.getName());

            this.currentRoom.addItemToRoom(item);
        }
    }

    private void talkNPC(Command command)
    {
        if (!command.hasSecondWord())
        {
            System.out.println("Talk to who?");
            return;
        }

        String name = currentRoom.getNPCInRoom().getName();

        try {
            if (command.getSecondWord().equals(name))
            {
                System.out.println(currentRoom.getNPCInRoom().getQuest());
            }
        }
        catch (NullPointerException e)
        {
            System.out.println(currentRoom.getNPCInRoom().getName() + " is not in the room");
        }
    }

    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }

    private void unlockRoom(Command command)
    {
        if (!command.hasSecondWord())
        {
            System.out.println("Unlock what?");
            return;
        }

        Item key = currentRoom.getKey();

        if (command.getSecondWord().equals(currentRoom.getKey().getName()))
        {
            if (currentRoom.roomIsLocked(true))
            {
                System.out.println("The room is locked, do you have the key?");
                if (this.inventory.isInInventory(key))
                {
                    System.out.println("Room unlocked");
                    inventory.removeFromInventory(key);
                    currentRoom.roomIsLocked(false);
                }
            }
        }
    }

    private void eatFood(Command command)
    {
        Item item = null;

        if (!command.hasSecondWord())
        {
            System.out.println("Eat what?");
            return;
        }
        if (itemList.containsKey(command.getSecondWord()))
        {
            item = itemList.get(command.getSecondWord());
        }
        if (item.getItemCategory() == "food")
        {
            inventory.removeFromInventory(item);
            System.out.println("Ate " + item.getName());

            if (command.getSecondWord().equals("handsanitizer"))
            {
                System.out.println("Too bad you died!\n");
            }
        }
        else
        {
            System.out.println("You can't eat that");
        }
    }

    private void examine(Command command)
    {
        if (!command.hasSecondWord())
        {
            System.out.println("Not valid command");
            return;
        }

        try {
            Item item = null;

            if (itemList.containsKey(command.getSecondWord()))
            {
                item = itemList.get(command.getSecondWord());
            }

            if (command.hasSecondWord())
            {
                if (command.getSecondWord().equals("room"))
                {
                    System.out.println(currentRoom.itemsInRoom());
                }
                else if (inventory.isInInventory(item))
                {
                    System.out.println("You examine " + command.getSecondWord() +
                            ".\nThe item" + item.getItemDescription());
                }
                else
                {
                    System.out.println("Can't examine that.");
                }
            }
        } catch (NullPointerException e)
        {
            System.out.println("There is nothing of interest in the room");
        }
    }
}