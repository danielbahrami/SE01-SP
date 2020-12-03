package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pandemic.Inventory;

public class InventoryController
{

    private Inventory inventory;

    @FXML
    private Button closeButton;

    @FXML
    private void closeInventory(MouseEvent event) throws Exception
    {
        if (event.getSource() == closeButton)
        {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }
}
