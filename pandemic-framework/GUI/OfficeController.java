package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pandemic.Inventory;

public class OfficeController {

    @FXML
    private Button rightButton,leftButton,upButton,downButton;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == rightButton){
            stage = (Stage) rightButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("NorthHallway.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void toInventory(MouseEvent event)
    {

    }
}