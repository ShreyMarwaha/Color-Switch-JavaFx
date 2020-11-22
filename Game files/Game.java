package sample;


import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static javafx.scene.paint.Color.rgb;


public class Game {
    private Background background;

    @FXML
    private Pane GamePane;
    public void setBackground(Background background)
    {
        GamePane.setBackground(background);
    }
    @FXML
    private Node Obstacle1;
    @FXML
    private ImageView line;
    public void rotate()
    {
        RotateTransition rotate = new RotateTransition(Duration.seconds(4),Obstacle1);
        rotate.setByAngle(-360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

        TranslateTransition translate= new TranslateTransition(Duration.seconds(25),line);
        translate.setByX(-450);
        translate.play();

    }



    @FXML
    ImageView GamePauseButton;
    public void pauseMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InGameMenu.fxml"));

        Scene scene = GamePauseButton.getScene();
        root.translateYProperty().set(scene.getHeight());

        StackPane parent = (StackPane) scene.getRoot();
        parent.getChildren().add(root);
        Timeline timeline1 = new Timeline();
        KeyValue kv1 = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_OUT);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(0.5),kv1);
        timeline1.getKeyFrames().add(kf1);
        timeline1.play();
        System.out.println("in game pause menu");
    }

    private int jumpCount = 0;
    @FXML
    private Circle xBall;
    @FXML
    private ImageView tail;
    public void jump()
    {
        if(jumpCount==3)
        {
            ArrayList<Color> colors = new ArrayList<Color>(4);
            colors.add(rgb(251, 4, 132));
            colors.add(rgb(140, 20, 251));
            colors.add(rgb(243, 220, 12));
            colors.add(rgb(52, 227, 243));
            Random rand = new Random();
            int x = rand.nextInt(4);
            xBall.setFill(colors.get(x));
        }
        jumpCount++;
        Timeline timeline = new Timeline();
        KeyValue kv1 = new KeyValue(xBall.centerYProperty(),xBall.getCenterY()-40,Interpolator.EASE_OUT);
        KeyValue kv2 = new KeyValue(tail.yProperty(),tail.getY()-40,Interpolator.EASE_OUT);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(0.4),kv2);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(0.4),kv1);
        timeline.getKeyFrames().add(kf2);
        timeline.getKeyFrames().add(kf1);
        timeline.play();
        System.out.println("jump");
    }

    private void fall()
    {
        Timeline timelineFall = new Timeline();
        KeyValue kvF = new KeyValue(xBall.centerYProperty(),xBall.getCenterY()+1,Interpolator.EASE_IN);
        KeyFrame kfF = new KeyFrame(Duration.seconds(0.01),kvF);
        timelineFall.getKeyFrames().add(kfF);
        timelineFall.play();
        System.out.println("fall");
    }
}
