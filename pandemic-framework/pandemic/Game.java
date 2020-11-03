package pandemic;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Item item;
    private Inventory inventory;

    public Game() 
    {
        createRooms();
        createNPC();
        parser = new Parser();
        this.inventory = new Inventory();
    }


    private void createRooms()
    {
         Room spawn, room1, room2, room3, room4, room5, room6, room7, room8, room9, room10;
      
        lobby = new Room("You are standing in the lobby", 0);
        reception = new Room("the reception and behind the is a woman", 1);
        pharmacy = new Room("pharmacy and you see different types of medication", 2);
        southHallway = new Room("room 3 and you can see an item (vitamin C) on the table", 3);
        lounge = new Room("reception and you can see the receptionist and an item (mask)", 4);
        cafeteria = new Room("room 5 and you see nothing of interest", 5);
        midHallway = new Room("room 6 and you see a person", 6);
        toilet = new Room("room 7 and you see a person", 7);
        northHallway = new Room("room 8 and you see nothing", 8);
        office = new Room("room 9 and you see a person", 9);
        secretRoom = new Room("room 10 and you see nothing", 10);


        spawn.setExit("left", room1);

        lobby.setExit("right", spawn);
        lobby.setExit("up", room4);
        lobby.setExit("left", room2);

        reception.setExit("right", room1);
        reception.setExit("up", room5);

        pharmacy.setExit("left", room4);
        pharmacy.setExit("up", room6);

        lounge.setExit("down", room1);
        lounge.setExit("right", room3);
        lounge.setExit("left", room5);

        cafeteria.setExit("down", room2);
        cafeteria.setExit("right", room4);
        cafeteria.setExit("up", room7);

        room6.setExit("up", room8);
        room6.setExit("down", room3);

        room7.setExit("down", room5);
        room7.setExit("up", room10);

        room8.setExit("down", room6);
        room8.setExit("left", room9);

        room9.setExit("right", room8);

        room10.setExit("down", room7);


        // roomNumber.addItemToRoom(< nameOfItem >, < itemDescription >;

        room4.addItemToRoom("mask", "a mask to protect your face");
        room1.addItemToRoom("soap", "soap to wash your hands");

        // roomNumber.addNPCToRoom(< NPCName >, < quest >, < questItem >)
        NPC1.setQuestItem(new Item("mask", "a mask"));
        room1.addNPCToRoom("Bo", "I need mask", NPC1.getQuestItem());

        currentRoom = spawn;
    }
    
    private void createNPC()
    {
        /* SYNTAX for createNPC()
            NPC a, b, c... ;
            Item x, y, z... ;

            a = new NPC("someName");
            x = new Item("itemName");

            a.setQuest("questName", x);
            completeQuest(a, x);
         */
        
        
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
        else if (commandWord == CommandWord.PICKUP)
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
            System.out.println("Pick up what?");
            return;
        }

        Item item = currentRoom.getItemInRoom();
        this.item = item;

        try {
            if (command.getSecondWord().equals(currentRoom.getItemInRoom().getName())) {
                inventory.addToInventory(item);
                System.out.println("picked up " + item.getName());
            }
        } catch (NullPointerException e)
        {
            System.out.println("There is no " + command.getSecondWord() + " in the room");
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
        }
    }
                
    
    public void giveItem(Command command)
    {
        if (!command.hasSecondWord())
        {
            System.out.println("Give what?");
            return;
        }

        Item item = new Item(command.getSecondWord(), currentRoom.getItemDescription());

        if (command.hasSecondWord())
        {
            if (command.getSecondWord().equals(item.getName()))
            {
                item = new Item(command.getSecondWord(), currentRoom.getItemDescription());
                inventory.removeFromInventory(item);
            }
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

    public Room getCurrentRoom()
    {
        return this.currentRoom;
    }

    private void completeQuest(NPC npc, Item item)
    {
        boolean done = npc.isQuestDone();

        if (item.getName() == npc.getQuest())
        {
            done = true;
        } else {
            done = false;
        }
    }
}
