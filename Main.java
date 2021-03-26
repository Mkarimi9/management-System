package oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage x;
    public static Stage stageReturner(){
        return x;

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GameDev");

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        x = primaryStage;

    }


    public static void main(String[] args) {
        launch(args);




    }
}
