package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TutorialController {

    @FXML
    Label tutorialText, tutorialLabel;

    @FXML
    Button exitButton;

    @FXML
    private void exitTutorial(MouseEvent event) {
        if (event.getSource() == exitButton) {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        }
    }
}