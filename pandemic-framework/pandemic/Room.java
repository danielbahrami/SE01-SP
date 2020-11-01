package pandemic;

import java.util.Set;
import java.util.HashMap;


public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Item> itemList;
    private int roomNumber;
    private String itemName;
    private String itemDescription;

    public Room(String description, int roomNumber)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        itemList = new HashMap<String, Item>();
        this.roomNumber = roomNumber;
        this.itemName = itemName;
        this.itemDescription = getItemDescription();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are in" + description + ".\n" + getExitString();
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
    
    public void addItemToRoom(String itemName, String itemDescription)
    {
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
}

