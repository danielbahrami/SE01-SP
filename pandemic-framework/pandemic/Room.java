package pandemic;

import java.util.Set;
import java.util.HashMap;


public class Room 
{
    // Room attributes
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> itemList;
    private HashMap<String, NPC> NPCList;
    private int roomNumber;

    // Item attributes
    private String itemName;
    private String itemDescription;

    // NPC attributes
    private String NPCName;
    private String quest;
    private Item questItem;


    // Create rooms
    public Room(String description, int roomNumber)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        itemList = new HashMap<String, Item>();
        NPCList = new HashMap<String, NPC>();


        this.roomNumber = roomNumber;
        this.itemName = itemName;
        this.itemDescription = getItemDescription();


        this.NPCName = NPCName;
        this.quest = quest;
        this.questItem = questItem;
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description + ".\n" + getExitString();
    }

    public String getLongDescription()
    {
        return "You are in " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public Room getCurrentRoom()
    {
        String description = this.description;
        int roomNumber = this.roomNumber;
        Room currentRoom = new Room(description, roomNumber);

        return currentRoom;
    }



    // Item methods to Room
    public void addItemToRoom(String itemName, String itemDescription)
    {
        this.itemName = itemName;
        itemList.put(itemName, new Item(itemName, itemDescription));
    }
    
    public String getItemDescription()
    {
        return itemDescription;
    }
    
    public Item getItemInRoom()
    {
        return itemList.get(itemName);
    }



    // NPC methods to Room
    public void addNPCToRoom(String NPCName, String quest, Item questItem)
    {
        this.NPCName = NPCName;
        this.quest = quest;
        this.questItem = questItem;
        NPCList.put(NPCName, new NPC(NPCName, quest, questItem));
    }

    public String getQuest()
    {
        return quest;
    }

    public NPC getNPCInRoom()
    {
        return NPCList.get(NPCName);
    }
}
