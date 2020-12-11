package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Pandemic.*;


public class PharmacyController {

    InventoryController ic = new InventoryController();
    Game game = new Game();
    Room room;
    Item item;

    @FXML
    private Button rightButton, upButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button itemButton;

    @FXML
    private ImageView imgView;

    public PharmacyController()
    {
        this.room = game.getCurrentRoom();
        this.item = room.getThisItem();
    }

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if (event.getSource() == rightButton) {
            stage = (Stage) rightButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
            stage.setTitle("Reception");
        } else {
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Cafeteria.fxml"));
            stage.setTitle("Cafeteria");
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openInventory(MouseEvent event) throws Exception {
        if (event.getSource() == inventoryButton) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Inventory");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void takeItem(MouseEvent event) throws Exception {
        if (event.getSource() == itemButton) {
            ic.addItemToInventory(item);
            System.out.println(ic.getInventory());
            imgView.setImage(null);
            itemButton.setDisable(true);
            this.room.removeItemFromRoom("Pills");
        }
    }
}

