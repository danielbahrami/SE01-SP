package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TutorialController {
    @FXML
    TextArea tutorialText;

    private void setTutorialText()
    {
        tutorialText.setText("");
    }
}
