package pandemic;

import java.util.HashMap;

/* This is the class for an item.
    The function of this is to let the game know
    what the name and function of the item is
*/
public class Item {

    private String name;
    private String function;
    private Item item;
    private String itemDescription;
    private HashMap<String, Item> itemList;


    public Item(String name, String itemDescription)
    {
        this.function = getItemFunction();
        this.name = name;
        this.itemDescription = itemDescription;
        itemList = new HashMap<String, Item>();
    }



    /* This is where we create items for the game.
        itemList.put(String <name>, new Item <name, description>));
     */
    public void addItems()
    {
        itemList.put("mask", new Item("mask", "a mask made to protecc"));
    }

    public String getItemDescription()
    {
        return itemDescription;
    }

    public String getName() {
        return name;
    }

    /* The function method is build up by if-statements.
        For each case we need to return another method fx shoot
     */
    public void setItemFunction(CommandWord function)
    {

    }

    public String getItemFunction()
    {
        return function;
    }


    public Item getItem()
    {
        return item;
    }
}
