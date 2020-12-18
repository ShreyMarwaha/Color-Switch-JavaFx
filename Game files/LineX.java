package sample;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.Serializable;

class LineX extends Shape {
    Group obstacleGroup = new Group();
    Line line1  =new Line();
    Line line2  =new Line();
    Line line3  =new Line();
    Line line4  =new Line();
    Line line5  =new Line();
    Line line6  =new Line();
    Line line7  =new Line();
    Line line8  =new Line();
    Line line9  =new Line();
    Line line10 =new Line();




    int id =3;
    public LineX(){
        this.make();
    }


    void make() {

        line1.setStroke(Color.DEEPPINK);
        line1.setStrokeWidth(10);
        line1.setStartX(0);
        line1.setEndX(70);

        line2.setStroke(Color.CYAN);
        line2.setStrokeWidth(10);
        line2.setStartX(70);
        line2.setEndX(140);

        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(10);
        line3.setStartX(140);
        line3.setEndX(210);

        line4.setStroke(Color.DARKVIOLET);
        line4.setStrokeWidth(10);
        line4.setStartX(210);
        line4.setEndX(280);

        line5.setStroke(Color.DEEPPINK);
        line5.setStrokeWidth(10);
        line5.setStartX(280);
        line5.setEndX(350);

        line6.setStroke(Color.CYAN);
        line6.setStrokeWidth(10);
        line6.setStartX(350);
        line6.setEndX(420);

        line7.setStroke(Color.YELLOW);
        line7.setStrokeWidth(10);
        line7.setStartX(420);
        line7.setEndX(490);

        line8.setStroke(Color.DARKVIOLET);
        line8.setStrokeWidth(10);
        line8.setStartX(490);
        line8.setEndX(560);

        line9.setStroke(Color.DEEPPINK);
        line9.setStrokeWidth(10);
        line9.setStartX(560);
        line9.setEndX(630);

        line10.setStroke(Color.CYAN);
        line10.setStrokeWidth(10);
        line10.setStartX(630);
        line10.setEndX(700);


        obstacleGroup.getChildren().addAll(line1,line2,line3,line4,line5,line6,line7,line8,line9,line10);
        rotate();
    }
    TranslateTransition translateY;
    TranslateTransition translateX;
    public void rotate()
    {
         translateY = new TranslateTransition(Duration.seconds(20),obstacleGroup);
        translateY.setInterpolator(Interpolator.LINEAR);
        translateY.setToY(1000);
        translateY.play();

        translateX = new TranslateTransition(Duration.seconds(5),obstacleGroup);
        translateX.setInterpolator(Interpolator.LINEAR);
        translateX.setToX(-280);
        translateX.setCycleCount(5);
        translateX.play();
    }

    public void pauseLin(){
        translateX.pause();
        translateY.pause();
    }
    public void resumeLin(){
        translateX.play();
        translateY.play();
    }

}
