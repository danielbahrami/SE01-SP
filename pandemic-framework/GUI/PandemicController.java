package GUI;

import javafx.fxml.FXML;
import pandemic.Player;
import pandemic.Sprite;

public class PandemicController {

    @FXML
    public Player player;

    @FXML
    public void createPlayer(Player player)
    {
        this.player = player;


    }

    // Create sprite. spriteName, positionX and positionY
    @FXML
    public void createSprite(String imageName, double x, double y)
    {
        Sprite sprite = new Sprite();
        sprite.setImage(imageName);
        sprite.setPosition(x, y);
    }
}
