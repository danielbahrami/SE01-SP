package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Pandemic.*;

    public class PandemicController {

        @FXML
        private Parent root;

        @FXML
        private Stage stage;

        @FXML
        private Button leftButton, rightButton, upButton, downButton;

        Game game = new Game();
        private final Room currentRoom = game.getCurrentRoom();
        String roomFXML = currentRoom.toString() + ".fxml";

        // Create sprite. spriteName, positionX and positionY
    /*@FXML
    public void createItem(String itemImage, double x, double y)
    {
        Sprite sprite = new Sprite();
        sprite.setImage(itemImage);
        sprite.setPosition(x, y);
        sprite.setVelocity(0,0);
    }*/


        @FXML
        private void goLeft(ActionEvent event) throws Exception
        {


            if (event.getSource() == leftButton && currentRoom.getRoomNumber() == 0)
            {
                stage = (Stage) leftButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
            }
            else if (event.getSource() == leftButton && currentRoom.getRoomNumber() == 1)
            {
                stage = (Stage) leftButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Pharmacy.fxml"));
            }
            else if (event.getSource() == leftButton && currentRoom.getRoomNumber() == 3)
            {
                stage = (Stage) leftButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Lounge.fxml"));
            }
            else if (event.getSource() == leftButton && currentRoom.getRoomNumber() == 4)
            {
                stage = (Stage) leftButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Cafeteria.fxml"));
            }
            else if (event.getSource() == leftButton && currentRoom.getRoomNumber() == 8)
            {
                stage = (Stage) leftButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Office.fxml"));
            }
            else
            {
                System.out.println(roomFXML);
                stage = (Stage) leftButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Lobby.fxml"));
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        private void goRight(ActionEvent event) throws Exception
        {
            if (event.getSource() == rightButton && currentRoom.getRoomNumber() == 1)
            {
                stage = (Stage) rightButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Lobby.fxml"));
            }
            else if (event.getSource() == rightButton && currentRoom.getRoomNumber() == 2)
            {
                stage = (Stage) rightButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
            }
            else if (event.getSource() == rightButton && currentRoom.getRoomNumber() == 4)
            {
                stage = (Stage) rightButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("SouthHallway.fxml"));
            }
            else if (event.getSource() == rightButton && currentRoom.getRoomNumber() == 5)
            {
                stage = (Stage) rightButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Lounge.fxml"));
            }
            else if (event.getSource() == rightButton && currentRoom.getRoomNumber() == 9)
            {
                stage = (Stage) rightButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("NorthHallway.fxml"));
            }
            else
            {
                stage = (Stage) rightButton.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
            }

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        @FXML
        private void goUp(ActionEvent event)
        {

        }

        @FXML
        private void goDown(ActionEvent event)
        {

        }

    /*@FXML
    public void moveRoom(ActionEvent event) throws IOException
    {
        Stage stage;
        String direction;

        currentRoom = game.getCurrentRoom();

        String fullCommand = "go ";
        direction = button.getId();
        Room nextRoom = currentRoom.getExit(direction);
        game.goRoom(command);
        currentRoom = nextRoom;

        Scene scene = new Scene(currentRoom);

    }*/
    }