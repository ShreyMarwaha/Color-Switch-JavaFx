package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

class CrossX extends Shape{
    Group obstacleGroup = new Group();
    transient Line up = new Line();
    transient Line down = new Line();
    transient Line left = new Line();
    transient Line right = new Line();
    //x1 y1 to x2 y2

    public CrossX(){
        this.make();
    }


    void make() {

        down.setStroke(Color.DEEPPINK);
        down.setStrokeWidth(10);
        down.setScaleX(15);
        down.setTranslateX(450);

        up.setStroke(Color.CYAN);
        up.setStrokeWidth(10);
        up.setScaleX(15);
        up.setTranslateX(300);

        right.setStroke(Color.DARKVIOLET);
        right.setStrokeWidth(10);
        right.setScaleY(15);
        right.setTranslateY(75);
        right.setTranslateX(190+190-5);

        left.setStroke(Color.YELLOW);
        left.setStrokeWidth(10);
        left.setScaleY(15);
        left.setTranslateY(-75);
        left.setTranslateX(190+190-5);

        obstacleGroup.getChildren().addAll(up,down,left,right);
        obstacleGroup.setTranslateX(obstacleGroup.getTranslateX()-75);
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
