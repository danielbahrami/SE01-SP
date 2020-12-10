package Pandemic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Start extends Application {

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Pandemic Game");
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Lobby.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        /*Stage inventoryStage = new Stage();
        Parent inventoryRoot = FXMLLoader.load(getClass().getResource("/GUI/Inventory.fxml"));
        Scene inventoryScene = new Scene(inventoryRoot);
        inventoryStage.setScene(inventoryScene);
        inventoryStage.show();*/
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
