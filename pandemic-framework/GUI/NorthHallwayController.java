package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Pandemic.Inventory;
import Pandemic.Item;
import Pandemic.NPC;
import javafx.stage.StageStyle;

public class NorthHallwayController {

    @FXML
    private Button leftButton, downButton, inventoryButton;

    @FXML
    private Label questLabel, completeLabel;

    private NPC npc = new NPC("Flemming", "I lost my inhaler and\nI can't remember in which room.\n Would you please help me\n find it?", new Item("inhaler","an inhaler for lung patients", "item", ""));
    private Inventory inventory = new Inventory();

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == leftButton){
            stage = (Stage) leftButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Office.fxml"));
        }
        else{
            stage = (Stage) downButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MidHallway.fxml"));
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
    private void talkToNpc(MouseEvent event)
    {
        questLabel.setText(npc.getQuest());
        questLabel.setVisible(false);

        String css = this.getClass().getResource("Stylesheet.css").toExternalForm();
        questLabel.getStylesheets().add(css);

        completeLabel.setVisible(false);
        completeLabel.getStylesheets().add(css);

        if (event.isPrimaryButtonDown())
        {
            questLabel.setVisible(true);
        }
        else if (event.isSecondaryButtonDown() && inventory.isInInventory(npc.getQuestItem()))
        {
            completeLabel.setText("Thank you!");
            completeLabel.setVisible(true);
        }
        else if (event.isSecondaryButtonDown() && !inventory.isInInventory(npc.getQuestItem()))
        {
            completeLabel.setText("Seems like you haven't\nfound my inhaler yet.");
            completeLabel.setVisible(true);
        }
    }
}
