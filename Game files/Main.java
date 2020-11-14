package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

//class Settings{
//    Color
//
//}

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");

        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
//        Scene scene1 = new Scene(root, 1000, 600);
//        Button switchScene = new Button("Switch");
//        switchScene.setOnAction(e->primaryStage.setScene(scene1));


//        BackgroundFill background_fill = new BackgroundFill(Color.PINK,
//                CornerRadii.EMPTY, Insets.EMPTY);
//
//        // create Background
//        Background background = new Background(background_fill);
//        primaryStage.

        // set background 
//        Component hbox;
//        hbox.setBackground(background);
    }



    public static void main(String[] args) {
        launch(args);

    }
}
