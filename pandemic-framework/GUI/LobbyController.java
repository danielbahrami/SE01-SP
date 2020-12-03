package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;


public class LobbyController{

    @FXML
    private Button leftButton,helpButton;



    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == leftButton){
            stage = (Stage) leftButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Reception.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void helpButtonClick(ActionEvent actionEvent) throws Exception{

        
        }
    }
