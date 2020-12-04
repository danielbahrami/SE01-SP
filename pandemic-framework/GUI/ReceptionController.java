package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pandemic.Game;
import pandemic.Inventory;
import pandemic.Item;
import pandemic.NPC;


public class ReceptionController{

    @FXML
    private Button rightButton,leftButton,upButton;

    @FXML
    private Button npcButton;

    Inventory inventory = new Inventory();

    private NPC npc = new NPC("Bo", "I forgot my mask,\nbut i was told I can find\n one in another room.\n Would you fetch me a mask?", new Item("mask", "a mask to protect your face", "item", ""));
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
        completeLabel.setText("");
        completeLabel.setVisible(false);

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
            System.out.println("Not in inventory");
        }

        /*Stage stage = new Stage();
        String message = npc.getQuest();

        Popup popup = new Popup();
        popup.setAutoFix(true);
        popup.setAutoHide(true);
        popup.setHideOnEscape(true);

        Label label = new Label(message);

        label.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                popup.hide();
            }
        });

        popup.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                popup.setX(stage.getX() + stage.getWidth() / 2 - popup.getWidth() / 2);
                popup.setY(stage.getY() + stage.getWidth() / 2 - popup.getWidth() / 2);
            }
        });

        popup.show(stage);
*/
    }
}