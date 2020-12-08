package pandemic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory = new ArrayList<>();

    public Inventory(ArrayList<Item> inventory)
    {
        this.inventory = inventory;
    }

    public Inventory()
    {

    }

    public void addToInventory(Item item)
    {
        if (this.inventory.size() >= 5)
        {
            System.out.println("Can't carry any more!");
        }
        else
        {
            this.inventory.add(item);
        }
    }


    public void removeFromInventory(Item item)
    {
        this.inventory.remove(item);
    }

    public void printInventory()
    {
        System.out.println("Items in your inventory: ");

        for (Item i : this.inventory)
        {
            if (this.inventory.size() > 1)
            {
                System.out.print(i.getName() + ", ");
            }
            else
            {
                System.out.print(i.getName());
            }
        }
    }

    public boolean isInInventory(Item item)
    {
        return this.inventory.contains(item);
    }

    public Item getItemsInInventory()
    {
        Item item = null;
        for (int i = 0; i < inventory.size(); i++)
        {
            item = inventory.get(i);

        }
        return item;
    }
}
