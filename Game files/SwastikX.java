package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class SwastikX extends Shape{
    Group obstacleGroup = new Group();
    transient Line up = new Line();
    transient Line down = new Line();
    transient Line left = new Line();
    transient Line right = new Line();
    //x1 y1 to x2 y2
    transient Line up2 = new Line();
    transient Line down2 = new Line();
    transient Line left2 = new Line();
    transient Line right2 = new Line();

    public SwastikX(){
        this.make();
    }


    void make() {

        down.setStroke(Color.DEEPPINK);
        down.setStrokeWidth(10);
        down.setScaleX(15);
        down.setTranslateY(200);
        down.setTranslateX(200-75);

        down2.setStroke(Color.DEEPPINK);
        down2.setStrokeWidth(10);
        down2.setScaleY(15);
        down2.setTranslateY(100+25);
        down2.setTranslateX(50);


        up.setStroke(Color.CYAN);
        up.setStrokeWidth(10);
        up.setScaleX(15);
        up.setTranslateX(300-25);
        up.setTranslateY(200);

        up2.setStroke(Color.CYAN);
        up2.setStrokeWidth(10);
        up2.setScaleY(15);
        up2.setTranslateY(100+25+150);
        up2.setTranslateX(300-25+75);

        right.setStroke(Color.DARKVIOLET);
        right.setStrokeWidth(10);
        right.setScaleY(15);
        right.setTranslateY(100+25+150);
        right.setTranslateX(50+150);

        right2.setStroke(Color.DARKVIOLET);
        right2.setStrokeWidth(10);
        right2.setScaleX(15);
        right2.setTranslateY(200+150);
        right2.setTranslateX(200-75);

        left.setStroke(Color.YELLOW);
        left.setStrokeWidth(10);
        left.setScaleY(15);
        left.setTranslateY(100+25);
        left.setTranslateX(50+150);

        left2.setStroke(Color.YELLOW);
        left2.setStrokeWidth(10);
        left2.setScaleX(15);
        left2.setTranslateX(300-25);
        left2.setTranslateY(50);

        obstacleGroup.getChildren().addAll(up,down,left,right,down2,up2,right2,left2);
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
