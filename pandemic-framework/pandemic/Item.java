package pandemic;

/* This is the class for an item.
    The function of this is to let the game know
    what the name and function of the item is
*/
public class Item {

    private String name;
    private String function;
    private String itemDescription;
    private String category;
    private Sprite sprite;
    private String spriteName;


    public Item(String name, String itemDescription, String category) {
        this.function = getItemFunction();
        this.name = name;
        this.itemDescription = itemDescription;
        this.category = category;
    }

    public Item(String name, String itemDescription, String category, String spriteName) {
        this.function = getItemFunction();
        this.name = name;
        this.itemDescription = itemDescription;
        this.category = category;
        this.spriteName = spriteName;

        this.sprite = new Sprite();
        sprite.setImage(spriteName);
    }


    public String getItemDescription() {
        return this.itemDescription;
    }

    public String getName() {
        return this.name;
    }

    /* The function method is build up by if-statements.
        For each case we need to return another method fx shoot
     */
    public void setItemFunction(CommandWord function) {

    }

    public String getItemFunction() {
        return this.function;
    }


    public String getItemCategory() {
        return this.category;
    }
}
