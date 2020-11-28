package GUI;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import pandemic.Player;
import pandemic.Sprite;

public class PandemicController {

    @FXML
    private Player player;
    private Sprite walls;
    private Sprite item;

    @FXML
    public void createPlayer(Player player)
    {
        this.player = player;


    }

    // Create sprite. spriteName, positionX and positionY
    @FXML
    public void createItem(String itemImage, double x, double y)
    {
        Sprite sprite = new Sprite();
        sprite.setImage(itemImage);
        sprite.setPosition(x, y);
        sprite.setVelocity(0,0);
    }

    @FXML
    public void createBackground(String backGroundImage, Sprite walls)
    {
        Image image = new Image(backGroundImage);
        Sprite wall = new Sprite();
        this.walls = walls;
        wall.setImage(walls.toString());
        wall.setPosition(0,0);
        wall.setVelocity(0,0);
    }



    @FXML
    public void move()
    {
        new AnimationTimer()
        {
            @Override
            public void handle(long l)
            {

            }
        }.start();
    }
}