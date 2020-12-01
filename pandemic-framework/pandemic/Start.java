package pandemic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;


public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Lobby.fxml"));
        Parent root = fxmlLoader.load();
        fxmlLoader.getController();
        Scene scene = new Scene(root);

        stage.setTitle("Pandemic Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        launch(args);
        game.play();
    }
}