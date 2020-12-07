package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pandemic.Item;

public class InventoryController
{
    @FXML
    private Button closeButton;

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, String> itemName, itemDescription;

    ObservableList<Item> items = FXCollections.observableArrayList();
    Item item;

    @FXML
    private void closeInventory(MouseEvent event) throws Exception
    {
        if (event.getSource() == closeButton)
        {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }

    private void initData(Item item)
    {
        this.item = item;

        itemName.setCellValueFactory(new PropertyValueFactory<Item, String>("Name"));
        itemDescription.setCellValueFactory(new PropertyValueFactory<Item, String>("Description"));

        tableView.getItems();
    }

    /*
    public ObservableList<Item> addToInventory(Item item)
    {
        ObservableList<Item> items = FXCollections.observableArrayList();
        item = new Item(null, null);
        this.item = item;
        items.add(newItem(item));

        return items;
    }
    */

    public void addToInventory(Item item)
    {

    }
}
