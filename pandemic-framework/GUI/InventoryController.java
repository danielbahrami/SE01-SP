package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pandemic.Item;

public class InventoryController
{
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

    @FXML
    private ObservableList<Item> getItems()
    {
        ObservableList<Item> inventory = FXCollections.observableArrayList();


        return inventory;
    }
}
