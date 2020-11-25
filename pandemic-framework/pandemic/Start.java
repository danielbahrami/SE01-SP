package pandemic;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void start(Stage stage)
    {

        stage.setTitle("Pandemic");
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas canvas = new Canvas(700, 500);
        root.getChildren().add(canvas);

        stage.show();

    }

    public static void main(String[] args)
    {
        Game game = new Game();
        launch(args);
        game.play();
    }
}