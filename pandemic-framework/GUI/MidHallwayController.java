package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MidHallwayController {
    @FXML
    private Button rightButton,leftButton,upButton,downButton;

    @FXML
    void buttonAction(MouseEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource() == upButton){
            stage = (Stage) upButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("NorthHallway.fxml"));
        }
        else{
            stage = (Stage) downButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("SouthHallway.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
  }
}