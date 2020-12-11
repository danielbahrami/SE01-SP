package Pandemic;

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

        lobby = new Room("the lobby", 0);
        reception = new Room("the reception", 1);
        pharmacy = new Room("the pharmacy", 2);
        southHallway = new Room("southern part of the hallway", 3);
        lounge = new Room("a lounge", 4);
        cafeteria = new Room("the cafeteria", 5);
        midHallway = new Room("the middle part of the hallway", 6);
        toilet = new Room("the toilet", 7);
        northHallway = new Room("northern part of the hallway ", 8);
        office = new Room("an office", 9);
        secretRoom = new Room("the secret room", 10);

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


        // roomNumber.addItemToRoom(< nameOfItem >, < itemDescription >, < category >;

        Item para = new Item ("paracetamol", "Paracetamol to treat pain and fever", "item", "");
        pharmacy.addItemToRoom(para);
        Item soap = new Item("soap", "Soap to wash your hands", "item", "");
        toilet.addItemToRoom(soap);
        Item handsanitizer = new Item ("handsanitizer", "Handsanitizer to disinfect your hands", "poison", "");
        southHallway.addItemToRoom(handsanitizer);
        Item inhaler = new Item("inhaler", "An inhaler to lung patients", "item", "");
        office.addItemToRoom(inhaler);
        Item manager = new Item("manager", "A manager to satisfy Karen", "item", "");
        secretRoom.addItemToRoom(manager);
        Item sandwich = new Item("sandwich", "A delicious sandwich made with love", "food", "");
        cafeteria.addItemToRoom(sandwich);
        Item plant = new Item("plant", "A beautiful plant from Plantorama", "item", "");
        lounge.addItemToRoom(plant);
        Item mask = new Item("mask", "A mask to protect your face", "item", "");
        midHallway.addItemToRoom(mask);

        //add item to the itemList hashmap

        this.itemList.put(para.getName(), para);
        this.itemList.put(soap.getName(), soap);
        this.itemList.put(handsanitizer.getName(), handsanitizer);
        this.itemList.put(inhaler.getName(), inhaler);
        this.itemList.put(manager.getName(), inhaler);
        this.itemList.put(sandwich.getName(), sandwich);
        this.itemList.put(plant.getName(), plant);
        this.itemList.put(mask.getName(), mask);


        // roomNumber.addNPCToRoom(< NPCName >, < quest >, < questItem >)
        reception.addNPCToRoom("Bo", "I forgot my mask, but i was told I can find one in another room. Would you fetch me a mask?", new Item("mask", "a mask to protect your face", "item"));
        office.addNPCToRoom("Karen", "I need to talk to the manager", new Item("manager", "a manager to satisfy Karen", "item"));
        northHallway.addNPCToRoom("Flemming", "I lost my inhaler and i can't remember in which room... Would you please help me find it?", new Item("inhaler","an inhaler for lung patients", "item"));

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

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.TAKE) {
            pickUp(command);
        } else if (commandWord == CommandWord.USE) {
            useItem(command);
        } else if (commandWord == CommandWord.GIVE) {
            giveItem(command);
        } else if (commandWord == CommandWord.INVENTORY) {
            showInventory(command);
        } else if (commandWord == CommandWord.UNLOCK) {
            unlockRoom(command);
        } else if (commandWord == CommandWord.TALK) {
            talkNPC(command);
        } else if (commandWord == CommandWord.DROP) {
            dropItem(command);
        } else if (commandWord == CommandWord.EAT) {
            eatFood(command);
            wantToQuit = atePoison(command);
        } else if (commandWord == CommandWord.EXAMINE) {
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

    public void goRoom(Command command)
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

    public void pickUp(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }
        // checks if an item is in the current room and makes it possible to only pick up items in rooms with items

        try {
            ArrayList<Item> itemArray = currentRoom.getItemInRoom();
            for (Item i : itemArray)
            {
                if (command.getSecondWord().equals(i.getName()))
                {
                    inventory.addToInventory(i);
                    System.out.println("You took " + i.getName());
                    currentRoom.removeItemFromRoom(i.getName());
                }

                if (currentRoom.itemsInRoom() == null) {
                    System.out.println("Item is not in the room.");
                }
            }
            //if the second word is the same as the NPC in the room, you won't be able to pick the NPC up

            if (command.getSecondWord().equals(currentRoom.getNPCInRoom().getName()))
            {
                System.out.println("Can't take " + command.getSecondWord());
            }

        }
        catch (NullPointerException e)
        {
            System.out.print("");
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

        //checks if the NPC is in the room you're in and checks if you have the correct item. only then is it able to give an item
        try
        {
            Item item = currentRoom.getNPCInRoom().getQuestItem();
            Item questItem;

            if (command.getSecondWord().equals(currentRoom.getNPCInRoom().getQuestItem().getName()))
            {
                if (this.itemList.containsKey(command.getSecondWord()))
                {
                    questItem = itemList.get(command.getSecondWord());

                    if (inventory.isInInventory(questItem))
                        System.out.println("Gave " + item.getName() + " to " + currentRoom.getNPCInRoom().getName()
                                + "\nQuest complete!");

                    else
                    {
                        System.out.println("You don't have that in your inventory.");
                    }

                    if (this.inventory.isInInventory(questItem))
                    {
                        this.inventory.removeFromInventory(questItem);
                    }
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

        //checks if out itemList contains the second word given and if it's true, gives "item" a value.
        if (itemList.containsKey(command.getSecondWord()))
        {
            item = itemList.get(command.getSecondWord());
        }

        //if the if "item" is assigned a value, then it proceeds to execute the following if statement
        if (inventory.isInInventory(item))
        {
            inventory.removeFromInventory(item);
            System.out.println("Dropped " + item.getName());

            this.currentRoom.addItemToRoom(item);
        }
        else
        {
            System.out.println("You don't have that in your inventory.");
        }
    }

    private void talkNPC(Command command)
    {
        if (!command.hasSecondWord())
        {
            System.out.println("Talk to who?");
            return;
        }

        try
        {
            String name = currentRoom.getNPCInRoom().getName();

            if (command.getSecondWord().equals(name))
            {
                System.out.println(currentRoom.getNPCInRoom().getQuest());
            }

            else if (!command.getSecondWord().equals(name))
            {
                System.out.println("the person in this room isn't called that");
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("No one is in the room.");
        }
    }

    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else
        {
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
        if (!inventory.isInInventory(item))
        {
            System.out.println("You don't have that item");
            return;
        }

        if (item.getItemCategory().equals("food") && inventory.isInInventory(item))
        {
            inventory.removeFromInventory(item);
            System.out.println("Ate " + item.getName());
        }

        if (item.getItemCategory().equals("poison") && inventory.isInInventory(item))
        {
            inventory.removeFromInventory(item);
            System.out.println("Ate " + item.getName() + "\nToo bad, you died!");
        }

        else
        {
            System.out.println("You can't eat that");
        }
    }

    private void examine(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Examine what?");
            return;
        }

        try {
            Item item = null;

            if (itemList.containsKey(command.getSecondWord())) {
                item = itemList.get(command.getSecondWord());
            }

            if (command.hasSecondWord()) {
                if (command.getSecondWord().equals("room")) {
                    System.out.println(currentRoom.itemsInRoom());

                    if (currentRoom.getNPCInRoom() == null) {
                        System.out.println("There is no one in the room.");
                    } else {
                        System.out.println("You see a person named " + currentRoom.getNPCInRoom().getName() + " in the room.");
                    }

                } else if (inventory.isInInventory(item)) {
                    System.out.println("You examined " + command.getSecondWord() +
                            ".\nThe item: " + item.getItemDescription());
                } else {
                    System.out.println("Can't examine that.");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("There is nothing of interest in the room");
        }
    }

    private boolean atePoison(Command command)
    {
        return command.hasSecondWord() && command.getSecondWord().equals("handsanitizer");
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

}