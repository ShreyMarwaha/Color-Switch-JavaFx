package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class DiamondX extends Shape{
    Group obstacleGroup = new Group();
    Line line1 = new Line(-200, -50, -50, -50);
    Line line2 = new Line(-50, -200, -50, -50);
    Line line3 = new Line(100,-50,-50,-50);
    Line line4 = new Line(-50,100,-50,-50);
    Line line5 = new Line(-200,-50,-50,100);
    Line line6 = new Line(-50,100,100,-50);
    Line line7 = new Line(100,-50,-50,-200);
    Line line8 = new Line(-50,-200,-200,-50);


    public DiamondX(){
        this.make();
    }


    void make() {

        line1.setStroke(Color.CYAN);
        line1.setStrokeWidth(10);

        line2.setStroke(Color.YELLOW);
        line2.setStrokeWidth(10);

        line3.setStroke(Color.DEEPPINK);
        line3.setStrokeWidth(10);

        line4.setStroke(Color.DARKVIOLET);
        line4.setStrokeWidth(10);

        line5.setStrokeWidth(10);
        line5.setStroke(Color.CYAN);
        line6.setStroke(Color.DARKVIOLET);
        line6.setStrokeWidth(10);
        line7.setStroke(Color.DEEPPINK);
        line7.setStrokeWidth(10);
        line8.setStrokeWidth(10);
        line8.setStroke(Color.YELLOW);

        obstacleGroup.getChildren().addAll(line1,line5,line2,line6,line3,line7,line4,line8);
        obstacleGroup.setTranslateX(obstacleGroup.getTranslateX()+35);
        rotate();
    }
    RotateTransition rotate;
    TranslateTransition translate;
    public void rotate()
    {
        rotate = new RotateTransition(Duration.seconds(4),obstacleGroup);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();

        translate = new TranslateTransition(Duration.seconds(20),obstacleGroup);
        translate.setInterpolator(Interpolator.LINEAR);
        translate.setToY(1000);
        translate.play();

    }

    public void pauseCir(){
        rotate.pause();
        translate.pause();
    }
    public void resumeCir(){
        rotate.play();
        translate.play();
    }


}