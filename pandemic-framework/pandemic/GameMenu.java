package Pandemic;

        import javafx.animation.FillTransition;
        import javafx.application.Application;
        import javafx.application.Platform;
        import javafx.beans.binding.Bindings;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.paint.CycleMethod;
        import javafx.scene.paint.LinearGradient;
        import javafx.scene.paint.Stop;
        import javafx.scene.shape.Rectangle;
        import javafx.scene.text.Font;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.util.Duration;


public class GameMenu extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(new Scene(createContent()));
        stage.show();
    }


    private void gameRun() {
        try {
            stage.close();
            Parent root1 = FXMLLoader.load(getClass().getResource("/GUI/Lobby.fxml"));
            Scene scene = new Scene(root1);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Lobby");
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void tutorial() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/Tutorial.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            createContent().setDisable(true);
        }
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(1280, 720);

        Image bgImage = new Image(
                getClass().getResource("Menu.gif").toExternalForm(),
                1280, 720,
                false, true
        );


        VBox box = new VBox(
                3,
                new MenuItem("PLAY", () -> gameRun()),
                new MenuItem("TUTORIAL", () -> tutorial()),
                new MenuItem("QUIT", () -> Platform.exit())
        );

        box.setBackground(new Background(
                new BackgroundFill(Color.web("black", 0.6), null, null)
        ));
        box.setTranslateX(320);
        box.setTranslateY(450);

        root.getChildren().addAll(
                new ImageView(bgImage),
                box
        );

        return root;
    }

    private static class MenuItem extends StackPane {
        MenuItem(String name, Runnable action) {
            LinearGradient gradient = new LinearGradient(
                    0, 0.5, 1, 0.5, true, CycleMethod.NO_CYCLE,
                    new Stop(0.1, Color.web("black", 0.75)),
                    new Stop(1.0, Color.web("black", 0.15))
            );
            Rectangle bg0 = new Rectangle(250, 30, gradient);
            Rectangle bg1 = new Rectangle(250, 30, Color.web("black", 0.2));

            FillTransition ft = new FillTransition(Duration.seconds(0.6),
                    bg1, Color.web("black", 0.2), Color.web("white", 0.3));

            ft.setAutoReverse(true);
            ft.setCycleCount(Integer.MAX_VALUE);

            hoverProperty().addListener((o, oldValue, isHovering) -> {
                if (isHovering) {
                    ft.playFromStart();
                } else {
                    ft.stop();
                    bg1.setFill(Color.web("black", 0.2));
                }
            });

            Rectangle line = new Rectangle(5, 30);
            line.widthProperty().bind(
                    Bindings.when(hoverProperty())
                            .then(8).otherwise(5)
            );
            line.fillProperty().bind(
                    Bindings.when(hoverProperty())
                            .then(Color.RED).otherwise(Color.GRAY)
            );

            Text text = new Text(name);
            text.setFont(Font.font(22.0));
            text.fillProperty().bind(
                    Bindings.when(hoverProperty())
                            .then(Color.WHITE).otherwise(Color.GRAY)
            );

            setOnMouseClicked(e -> action.run());

            setOnMousePressed(e -> bg0.setFill(Color.LIGHTBLUE));

            setOnMouseReleased(e -> bg0.setFill(gradient));

            setAlignment(Pos.CENTER_LEFT);

            HBox box = new HBox(15, line, text);
            box.setAlignment(Pos.CENTER_LEFT);

            getChildren().addAll(bg0, bg1, box);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
