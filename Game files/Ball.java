package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;
import java.util.Random;

public class Ball implements Serializable{
    transient double distance;
    transient double velocity=0;
    transient double acceleration=9.0;
    transient double timeE;
    transient double initial;
    transient Circle ball = new Circle(5);
    transient Rectangle rect = new Rectangle(400,10, Color.BLACK);
    transient Random rand = new Random();
    int prev=-1;
    public Ball(){
        this.startBall();
    }


    public void startBall(){
        rect.setTranslateY(600);
        ball.setCenterY(300);
        ball.setTranslateY(300);
        ball.setCenterX(190);
        ball.setStroke(Color.BLUE);
        ball.setStrokeWidth(0);

        changeColor();
    }

    public void changeColor(){
        int i = rand.nextInt(4);
        if(i==prev)
        {
            if(i<2)
                i++;
            else
                i--;
        }
        prev=i;
        switch (i)
        {
            case 0: ball.setFill(Color.DEEPPINK); break;
            case 1: ball.setFill(Color.YELLOW); break;
            case 2: ball.setFill(Color.CYAN); break;
            case 3: ball.setFill(Color.DARKVIOLET); break;
        }

    }

    public void setColor(Color c)
    {
        ball.setFill(c);
    }
}
