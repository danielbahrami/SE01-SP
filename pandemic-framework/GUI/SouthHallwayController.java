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

public class SouthHallwayController {

    InventoryController ic = new InventoryController();
    Game game = new Game();
    Room room;
    Item item;

    public SouthHallwayController() {
        this.room = game.getCurrentRoom();
        this.item = room.getThisItem();
    }

    @FXML
    private Button rightButton, leftButton, upButton, downButton;

    @FXML
    private ImageView sanitizer;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if (event.getSource() == leftButton) {
            stage = (Stage) leftButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Lounge.fxml"));
        }
        else{
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MidHallway.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void takeItem(MouseEvent event) throws Exception {
        if (event.getSource() == sanitizer) {
            ic.addItemToInventory(item);
            System.out.println(ic.getInventory());
            sanitizer.setImage(null);
            sanitizer.setDisable(true);
            this.room.removeItemFromRoom("handsanitizer");
        }
    }
}