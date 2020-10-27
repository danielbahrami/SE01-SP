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
        parser = new Parser();
    }


    private void createRooms()
    {
         Room spawn, room2, room3, room4, room5, room6, room7, room8, room9, room10;
      
        spawn = new Room("Welcome to the nursing home");
        room2 = new Room("You've entered room 2 and inside this room you can see nothing");
        room3 = new Room("You've entered room 3 and you can see an item (vitamin C) on the table");
        room4 = new Room("You've entered room 4 and you can see a person and an item (mask)");
        room5 = new Room("You've entered room 5 and you see nothing of interest");
        room6 = new Room("You've entered room 6 and you see a person");
        room7 = new Room("You've entered room 7 and you see a person");
        room8 = new Room("You've entered room 8");
        room9 = new Room("You've entered room 9 and you see a person");
        room10 = new Room("You've entered room 10");


        spawn.setExit("up", room4);
        spawn.setExit("left", room2);

        room2.setExit("right", spawn);
        room2.setExit("up", room5);

        room3.setExit("left", room4);
        room3.setExit("up", room6);

        room4.setExit("down", spawn);
        room4.setExit("right", room3);
        room4.setExit("left", room5);

        room5.setExit("down", room2);
        room5.setExit("right", room4);
        room5.setExit("up", room7);

        room6.setExit("up", room8);
        room6.setExit("down", room3);

        room7.setExit("down", room5);
        room7.setExit("up", room10);

        room8.setExit("down", room6);
        room8.setExit("left", room9);

        room9.setExit("right", room8);

        room10.setExit("down", room7);


        currentRoom = spawn;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
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

        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
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

        Inventory inventory = null;
        Item item = new Item("");
        String itemCommand = command.getSecondWord();

        if (itemCommand == item.getName())
        {
            inventory.addToInventory(item);
        }
    }

    private void useItem()
    {

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


}
