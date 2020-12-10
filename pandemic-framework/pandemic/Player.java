package Pandemic;


/* This class makes the player in the game.
    The player has a current room, and a last room.
*/
public class Player {

    private Sprite sprite;

    public Player()
    {
        this.sprite = new Sprite();
    }

    /* The move-method is used in JavaFX only!
        This allows us to move the character in real time.
    */
    public void move()
    {

    }

    public Sprite getSprite()
    {
        return this.sprite;
    }

    public void setSprite(String spriteName)
    {
        this.sprite = new Sprite();
        sprite.setImage(spriteName);
    }
}
