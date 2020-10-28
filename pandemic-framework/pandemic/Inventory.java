package pandemic;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<>();

    public Inventory(ArrayList<Item> inventory)
    {
        this.inventory = inventory;
    }

    public Inventory()
    {
        this(new ArrayList<Item>());
    }

    public void addToInventory(Item item)
    {
        inventory.add(item);
    }
    
    public void removeFromInventory(Item item)
    {
        inventory.remove(item);
    }
    
    public void printInventory()
    {
        System.out.println("Items in your inventory: ");
        
        for (Item i : inventory)
        {
            System.out.println(i);
        }
    }
}
