package GUI;

import Pandemic.Game;
import Pandemic.Item;
import Pandemic.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MidHallwayController {

    InventoryController ic = new InventoryController();
    Game game = new Game();
    Room room;
    Item item;

    public MidHallwayController() {
        this.room = game.getCurrentRoom();
        this.item = room.getThisItem();
    }

    @FXML
    private Button rightButton,leftButton,upButton,downButton;

    @FXML
    private ImageView mask;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == upButton){
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("NorthHallway.fxml"));
        }
        else{
            stage = (Stage) downButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SouthHallway.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
  }

    @FXML
    private void takeItem(MouseEvent event) throws Exception {
        if (event.getSource() == mask) {
            ic.addItemToInventory(item);
            System.out.println(ic.getInventory());
            mask.setImage(null);
            mask.setDisable(true);
            this.room.removeItemFromRoom("mask");
        }
    }
}