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

public class CafeteriaController {

    InventoryController ic = new InventoryController();
    Game game = new Game();
    Room room;
    Item item;

    public CafeteriaController() {
        this.room = game.getCurrentRoom();
        this.item = room.getThisItem();
    }

    @FXML
    private Button rightButton,upButton,downButton;

    @FXML
    private ImageView sandwich;


    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == upButton){
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Toilet.fxml"));
        }
        else if(event.getSource() == downButton){
            stage = (Stage) downButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Pharmacy.fxml"));
        }
        else{
            stage = (Stage) rightButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Lounge.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void takeItem(MouseEvent event) throws Exception {
        if (event.getSource() == sandwich) {
            ic.addItemToInventory(item);
            System.out.println(ic.getInventory());
            sandwich.setImage(null);
            sandwich.setDisable(true);
            this.room.removeItemFromRoom("sandwich");
        }
    }
}