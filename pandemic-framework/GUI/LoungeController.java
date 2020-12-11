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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoungeController {

    InventoryController ic = new InventoryController();
    Game game = new Game();
    Room room;
    Item item;

    public LoungeController() {
        this.room = game.getCurrentRoom();
        this.item = room.getThisItem();
    }

    @FXML
    private Button rightButton,leftButton,downButton,inventoryButton;

    @FXML
    private ImageView plant;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == leftButton){
            stage = (Stage) leftButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Cafeteria.fxml"));
            stage.setTitle("Cafeteria");
        }
        else if(event.getSource() == rightButton){
            stage = (Stage) rightButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SouthHallway.fxml"));
            stage.setTitle("South Hallway");
        }
        else{
            stage = (Stage) downButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
            stage.setTitle("Reception");
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
        if (event.getSource() == plant) {
            ic.addItemToInventory(item);
            System.out.println(ic.getInventory());
            plant.setImage(null);
            plant.setDisable(true);
            this.room.removeItemFromRoom("plant");
        }
    }
}
