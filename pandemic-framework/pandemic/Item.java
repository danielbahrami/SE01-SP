package pandemic;

/* This is the class for an item.
    The function of this is to let the game know
    what the name and function of the item is
*/
public class Item {

    private String name;
    private String function;

    public Item(String name) {
        this.name = name;
        function = getItemFunction();
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

    public void setItem(Item item)
    {
        item = new Item(getName());
    }
}