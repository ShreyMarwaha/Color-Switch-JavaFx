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

class DoubleCircleX extends Shape{
    Group obstacleGroup = new Group();
    transient Arc up  =new Arc();
    transient Arc down  =new Arc();
    transient Arc left  =new Arc();
    transient Arc right  =new Arc();
    transient Arc up2  =new Arc();
    transient Arc down2  =new Arc();
    transient Arc left2  =new Arc();
    transient Arc right2  =new Arc();

    public DoubleCircleX(){
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


        up2.setRadiusX(90);
        up2.setRadiusY(90);
        up2.setFill(Color.TRANSPARENT);
        up2.setStroke(Color.DEEPPINK);
        up2.setStrokeWidth(10);
        up2.setStartAngle(45);
        up2.setLength(84);
        up2.setType(ArcType.OPEN);
        up2.setCenterY(-120);
        up2.setCenterX(190);

        left2.setRadiusX(90);
        left2.setRadiusY(90);
        left2.setFill(Color.TRANSPARENT);
        left2.setStroke(Color.YELLOW);
        left2.setStrokeWidth(10);
        left2.setStartAngle(135);
        left2.setLength(84);
        left2.setType(ArcType.OPEN);
        left2.setCenterY(-120);
        left2.setCenterX(190);


        down2.setRadiusX(90);
        down2.setRadiusY(90);
        down2.setFill(Color.TRANSPARENT);
        down2.setStroke(Color.CYAN);
        down2.setStrokeWidth(10);
        down2.setStartAngle(225);
        down2.setLength(84);
        down2.setType(ArcType.OPEN);
        down2.setCenterY(-120);
        down2.setCenterX(190);

        right2.setRadiusX(90);
        right2.setRadiusY(90);
        right2.setFill(Color.TRANSPARENT);
        right2.setStroke(Color.DARKVIOLET);
        right2.setStrokeWidth(10);
        right2.setStartAngle(315);
        right2.setLength(84);
        right2.setType(ArcType.OPEN);
        right2.setCenterY(-120);
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
