package pandemic;

import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void start(Stage stage)
    {

    }

    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }
}