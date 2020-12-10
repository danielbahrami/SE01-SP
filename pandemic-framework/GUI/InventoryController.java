package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pandemic.Inventory;
import pandemic.Item;


public class InventoryController
{
    private final Inventory inventory;

    @FXML
    private Button closeButton;

    @FXML
    private final TableView<Item> tableView;

    @FXML
    private final TableColumn<Item, String> itemName, itemDescription;


    public InventoryController()
    {
        this.inventory = new Inventory();
        tableView = new TableView<>();

        itemName = new TableColumn<>();
        itemDescription = new TableColumn<>();
        itemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        itemDescription.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));

        tableView.setItems(getInventory());
    }

    @FXML
    private void closeInventory(MouseEvent event)
    {
        if (event.getSource() == closeButton)
        {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
    }

    public void addItemToInventory(Item item)
    {
        inventory.addToInventory(item);
    }

    @FXML
    public ObservableList<Item> getInventory()
    {
        return FXCollections.observableArrayList(inventory.getItemsInInventory());
    }
}
