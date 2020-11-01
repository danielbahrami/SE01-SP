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
        if (inventory.size() > 5)
        {
            System.out.println("Can't carry any more!");
        }
        else
        {
            inventory.add(item);
        }
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
    
    @Override
    public String toString()
    {
        String s = item.getName();

        return s;
    }
}
