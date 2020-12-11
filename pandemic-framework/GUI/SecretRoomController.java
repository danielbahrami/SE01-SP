package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SecretRoomController {

    @FXML
    private Button downButton, inventoryButton;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if (event.getSource() == downButton) {
            stage = (Stage) downButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Toilet.fxml"));
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
}
