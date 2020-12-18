package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

class CircleX extends Shape {
    transient Arc up  =new Arc();
    transient Arc down  =new Arc();
    transient Arc left  =new Arc();
    transient Arc right  =new Arc();

    transient Group obstacleGroup = new Group();
    transient double centreOfDown;
    transient double centreOfUp;
    transient int id =1;
    public CircleX(){
        this.make();
    }


    void make(){

        up.setRadiusX(120);
        up.setRadiusY(120);
        up.setFill(Color.TRANSPARENT);
        up.setStroke(Color.DEEPPINK);
        up.setStrokeWidth(10);
        up.setStartAngle(45);
        up.setLength(90);
        up.setType(ArcType.OPEN);
        up.setCenterY(-120);
        up.setCenterX(190);

        centreOfUp=-120;
        centreOfDown=120;


        left.setRadiusX(120);
        left.setRadiusY(120);
        left.setFill(Color.TRANSPARENT);
        left.setStroke(Color.YELLOW);
        left.setStrokeWidth(10);
        left.setStartAngle(135);
        left.setLength(90);
        left.setType(ArcType.OPEN);
        left.setCenterY(-120);
        left.setCenterX(190);


        down.setRadiusX(120);
        down.setRadiusY(120);
        down.setFill(Color.TRANSPARENT);
        down.setStroke(Color.CYAN);
        down.setStrokeWidth(10);
        down.setStartAngle(225);
        down.setLength(90);
        down.setType(ArcType.OPEN);
        down.setCenterY(-120);
        down.setCenterX(190);

        right.setRadiusX(120);
        right.setRadiusY(120);
        right.setFill(Color.TRANSPARENT);
        right.setStroke(Color.DARKVIOLET);
        right.setStrokeWidth(10);
        right.setStartAngle(315);
        right.setLength(90);
        right.setType(ArcType.OPEN);
        right.setCenterY(-120);
        right.setCenterX(190);
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
    public void pauseCir(){
        rotate.pause();
        translate.pause();
    }
    public void resumeCir(){
        rotate.play();
        translate.play();
    }

}
