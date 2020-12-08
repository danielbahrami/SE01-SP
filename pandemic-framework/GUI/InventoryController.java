package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pandemic.Inventory;
import pandemic.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable
{
    private static Inventory inventory = new Inventory();

    @FXML
    private Button closeButton;

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, String> itemName, itemDescription;

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

    public void addItemToInventory(Item item)
    {
        inventory.addToInventory(item);
    }

    @FXML
    public ObservableList<Item> getInventory()
    {
        return FXCollections.observableArrayList(inventory.getItemsInInventory());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        tableView = new TableView<>();
        itemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemDescription.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));

        tableView.setItems(getInventory());
        tableView.getColumns().addAll(itemName, itemDescription);
    }
}
