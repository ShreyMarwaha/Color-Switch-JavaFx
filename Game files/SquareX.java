package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

class SquareX extends Shape  {
    Group obstacleGroup = new Group();
    Line up  =new Line();
    Line down  =new Line();
    Line left  =new Line();
    Line right  =new Line();

    int id =2;
    public SquareX(){
        this.make();
    }


    void make() {

        down.setStroke(Color.DEEPPINK);
        down.setStrokeWidth(10);
        down.setScaleX(20);
        down.setTranslateX(190);

        up.setStroke(Color.CYAN);
        up.setStrokeWidth(10);
        up.setScaleX(20);
        up.setTranslateY(-190 );
        up.setTranslateX(190);

        right.setStroke(Color.DARKVIOLET);
        right.setStrokeWidth(10);
        right.setScaleY(20);
        right.setTranslateY(-95);
        right.setTranslateX(190+105);

        left.setStroke(Color.YELLOW);
        left.setStrokeWidth(10);
        left.setScaleY(20);
        left.setTranslateY(-95);
        left.setTranslateX(190-105);

        obstacleGroup.getChildren().addAll(up,left,down,right);
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

    public void pauseSq(){
        rotate.pause();
        translate.pause();
    }
    public void resumeSq(){
        rotate.play();
        translate.play();
    }

}
