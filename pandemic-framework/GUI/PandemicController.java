package GUI;

import javafx.fxml.FXML;
import pandemic.Player;

public class PandemicController {

    @FXML
    public Player player;

    @FXML
    public void createPlayer(Player player)
    {
        this.player = player;


    }
}
