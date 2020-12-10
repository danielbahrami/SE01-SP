package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Pandemic.Game;
import Pandemic.Inventory;
import Pandemic.Item;
import Pandemic.NPC;
import GUI.InventoryController;

public class ReceptionController{

    @FXML
    private Button rightButton,leftButton,upButton;

    @FXML
    private Button npcButton;

    Inventory inventory = new Inventory();

    private NPC npc = new NPC("Bo", "I forgot my mask,\nbut i was told I can find\none in another room.\nWould you fetch me a mask?", new Item("mask", "a mask to protect your face", "item", ""));
    private Game game;

    @FXML
    Label questLabel, completeLabel;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == leftButton){
            stage = (Stage) leftButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Pharmacy.fxml"));
        }
        else if (event.getSource() == rightButton){
            stage = (Stage) rightButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Lobby.fxml"));
        }
        else{
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Lounge.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void talkToNpc(MouseEvent event)
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
            completeLabel.setText("Seems like you haven't\n found the mask yet.");
            completeLabel.setVisible(true);
        }
    }
}