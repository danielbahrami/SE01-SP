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
import pandemic.Item;

public class PharmacyController {

    InventoryController ic = new InventoryController();
    Item item = new Item("Pills", "Pills to treat pain and fever.");

    @FXML
    private Button rightButton,upButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button itemButton;

    @FXML
    private ImageView imgView;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == rightButton){
            stage = (Stage) rightButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
        }
        else{
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Cafeteria.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void openInventory(MouseEvent event) throws Exception
    {
        if (event.getSource() == inventoryButton)
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inventory.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Inventory");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void takeItem(MouseEvent event) throws Exception
    {
        if (event.getSource() == itemButton)
        {
            Item item = this.item;
            ic.addItemToInventory(item);
            System.out.println(ic.getInventory());

            if (ic.getInventory().contains(item)) {
                itemButton.setDisable(true);
                imgView.setImage(null);
            }
        }
    }

}
