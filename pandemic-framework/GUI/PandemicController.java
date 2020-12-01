package GUI;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pandemic.*;

import java.io.IOException;

public class PandemicController {

    @FXML
    private Player player;
    private Sprite walls;
    private Sprite item;
    private Button button;
    private Room currentRoom;
    private Command command;
    Game game = new Game();

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

    }

    @FXML
    public void goRoom(ActionEvent event) throws IOException
    {
        Stage stage;
        Parent root;
        String direction;

        currentRoom = game.getCurrentRoom();
        direction = button.getId();
        Room nextRoom = currentRoom.getExit(direction);



        if(event.getSource() == button)
        {
            stage = (Stage) button.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }



        /*currentRoom = game.getCurrentRoom();
        String direction = button.getId();
        String fullCommand = "go ";*/
    }
}