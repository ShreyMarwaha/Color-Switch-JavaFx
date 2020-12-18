package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.util.Duration;

class CircleInSquareX extends Shape{
    Group obstacleGroup = new Group();
    transient Line up  =new Line();
    transient Line right  =new Line();
    transient Line left  =new Line();
    transient Line down  =new Line();

    transient Arc up2  =new Arc();
    transient Arc down2  =new Arc();
    transient Arc left2  =new Arc();
    transient Arc right2  =new Arc();

    public CircleInSquareX(){
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

        up2.setRadiusX(100);
        up2.setRadiusY(100);
        up2.setFill(Color.TRANSPARENT);
        up2.setStroke(Color.CYAN);
        up2.setStrokeWidth(10);
        up2.setStartAngle(45);
        up2.setLength(90);
        up2.setType(ArcType.OPEN);
        up2.setCenterY(-95);
        up2.setCenterX(190);



        left2.setRadiusX(100);
        left2.setRadiusY(100);
        left2.setFill(Color.TRANSPARENT);
        left2.setStroke(Color.YELLOW);
        left2.setStrokeWidth(10);
        left2.setStartAngle(135);
        left2.setLength(90);
        left2.setType(ArcType.OPEN);
        left2.setCenterY(-95);
        left2.setCenterX(190);


        down2.setRadiusX(100);
        down2.setRadiusY(100);
        down2.setFill(Color.TRANSPARENT);
        down2.setStroke(Color.DEEPPINK);
        down2.setStrokeWidth(10);
        down2.setStartAngle(225);
        down2.setLength(90);
        down2.setType(ArcType.OPEN);
        down2.setCenterY(-95);
        down2.setCenterX(190);

        right2.setRadiusX(100);
        right2.setRadiusY(100);
        right2.setFill(Color.TRANSPARENT);
        right2.setStroke(Color.DARKVIOLET);
        right2.setStrokeWidth(10);
        right2.setStartAngle(315);
        right2.setLength(90);
        right2.setType(ArcType.OPEN);
        right2.setCenterY(-95);
        right2.setCenterX(190);

        obstacleGroup.getChildren().addAll(up,left,down,right,up2,left2,down2,right2);
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
