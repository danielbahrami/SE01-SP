package pandemic;

import javafx.scene.image.Image;

/* This class makes the player in the game.
    The player has a current room, and a last room.
*/
public class Player {

    private Image playerSprite;

    public Player()
    {
        this.playerSprite = new Image("playerSpritePath.png");
    }

    /* The move-method is used in JavaFX only!
        This allows us to move the character in real time.
    */
    public void move()
    {

    }
}
