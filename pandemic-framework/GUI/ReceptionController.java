package GUI;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pandemic.Item;
import pandemic.NPC;


public class ReceptionController{

    @FXML
    private Button rightButton,leftButton,upButton;

    private NPC npc = new NPC("Bo", "I forgot my mask, but i was told I can find one in another room. Would you fetch me a mask?", new Item("mask", "a mask to protect your face", "item", ""));

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

    public Popup createPopup()
    {
        String message = npc.getQuest();
        final Popup popup = new Popup();
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

        // Set styles

        popup.getContent().add(label);

        return popup;
    }

    @FXML
    public void showPopup(Stage stage)
    {
        Popup popup = createPopup();
        popup.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                popup.setX(stage.getX() + stage.getWidth() / 2 - popup.getWidth() / 2);
                popup.setY(stage.getY() + stage.getWidth() / 2 - popup.getWidth() / 2);
            }
        });

        popup.show(stage);
    }
}
