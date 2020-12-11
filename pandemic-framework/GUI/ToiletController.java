package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Pandemic.*;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;


public class ToiletController extends Inventory{

    InventoryController ic = new InventoryController();
    Game game = new Game();
    Room room;
    Item item;

    public ToiletController() {
        this.room = game.getCurrentRoom();
        this.item = room.getThisItem();
    }


    @FXML
    private Button downButton,upButton,inventoryButton;

    @FXML
    private ImageView soap;

    @FXML
    private Room currentRoom;

    @FXML
    private Inventory inventory;


    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if (event.getSource() == downButton) {
            stage = (Stage) downButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Cafeteria.fxml"));
        }
        else{
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SecretRoom.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openInventory(MouseEvent event) throws Exception
    {
        if (event.getSource() == inventoryButton) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Inventory");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void takeItem(MouseEvent event) throws Exception {
        if (event.getSource() == soap) {
            ic.addItemToInventory(item);
            System.out.println(ic.getInventory());
            soap.setImage(null);
            soap.setDisable(true);
            this.room.removeItemFromRoom("soap");
        }
    }
}
