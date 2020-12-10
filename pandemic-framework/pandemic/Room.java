package Pandemic;

import javafx.scene.image.Image;

import java.util.ArrayList;
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
    private Item key;

    // Room graphics
    private Image background;
    private Sprite itemSprite;
    private Sprite wall;


    // NPC attributes
    private String NPCName;
    private String quest;
    private Item questItem;
    private String NPCSprite;

    // Create rooms
    public Room(String description, int roomNumber)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        itemList = new HashMap<String, Item>();
        NPCList = new HashMap<String, NPC>();

        this.roomNumber = roomNumber;

        this.NPCName = NPCName;
        this.quest = quest;
        this.questItem = questItem;
    }

    public Room(String description, int roomNumber, Item key)
    {
        this(description, roomNumber);
        this.key = key;
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
        if (NPCName == null)
        {
            return "You are in " + description + ".\n" + getExitString();
        }
        if (getItemInRoom().size() == 0)
        {
            return "You are in " + description + ".\n" + getExitString();
        }
        if (getItemInRoom().size() == 0 && NPCName == null)
        {
            return "You are in " + description + ".\n" + getExitString();
        }
        
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
    
    public boolean roomIsLocked(boolean bool)
    {
        if (bool)
        {
            System.out.println("The room is locked!");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setKey(Item key)
    {
        this.key = key;
    }

    public Item getKey()
    {
        return key;
    }


    // Item methods to Room
    public void addItemToRoom(Item item)
    {
        itemList.put(item.getName(), item);
    }

    public void setItemPosition(double x, double y)
    {
        this.itemSprite.setPosition(x, y);
    }
    
    public void removeItemFromRoom(String itemName)
    {
        itemList.remove(itemName);
    }

    
    public ArrayList<Item> getItemInRoom() {
        return new ArrayList<>(itemList.values());
    }


    // NPC methods to Room
    public void addNPCToRoom(String NPCName, String quest, Item questItem, String NPCSprite)
    {
        this.NPCName = NPCName;
        this.quest = quest;
        this.questItem = questItem;
        this.NPCSprite = NPCSprite;
        
        Sprite sprite = new Sprite();
        sprite.setImage(NPCSprite);

        this.NPCList.put(NPCName, new NPC(NPCName, quest, questItem));
    }

    public String getQuest()
    {
        return quest;
    }

    public NPC getNPCInRoom()
    {
        return NPCList.get(NPCName);
    }

    public void setRoomDescription(String description)
    {
        this.description = description;
    }

    public String itemsInRoom()
    {
        String itemNames = "You see ";
        itemNames += itemList.keySet();
        itemNames += " in the room";

        return itemNames;
    }

    public int getRoomNumber()
    {
        return roomNumber;
    }
}
