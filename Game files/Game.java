package sample;

import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Game extends Main implements Serializable {
    static ArrayList<CircleX> allCircleObstacle = new ArrayList<>();
    static ArrayList<SquareX> allSquareObstacle = new ArrayList<>();
    static ArrayList<LineX> allLineObstacle = new ArrayList<>();
    static ArrayList<DoubleCircleX> allDoubleCircleObstacle = new ArrayList<>();
    static ArrayList<CircleInSquareX> allCircleInSquareObstacle = new ArrayList<>();
    static ArrayList<CrossX> allCrossObstacles = new ArrayList<>();
    static ArrayList<SwastikX> allSwastikObstacles = new ArrayList<>();
    static ArrayList<DiamondX> allDiamondObstacles = new ArrayList<>();
    Ball ball;
    int points;
    boolean pause = false;

    public Game()
    {
        points = 0;
        ball = new Ball();
    }
    public void pauseGame()
    {
        for(CircleX x:allCircleObstacle) {
            x.pauseCir();
        }
        for(LineX x:allLineObstacle) {
            x.pauseLin();

        }
        for(SquareX x:allSquareObstacle) {
            x.pauseSq();
        }
        for(DoubleCircleX x:allDoubleCircleObstacle) {
            x.pauseCir();
        }
        for(CircleInSquareX x : allCircleInSquareObstacle)
            x.pauseCir();
        for(CrossX x : allCrossObstacles)
            x.pauseCir();

        for(SwastikX x : allSwastikObstacles)
            x.pauseCir();
        for(DiamondX x : allDiamondObstacles)
            x.pauseCir();
        pause = true;
    }
    public void resumeGame(){
        pause = false;

        for(CircleX x:allCircleObstacle)
            x.resumeCir();
        for(LineX x:allLineObstacle)
            x.resumeLin();
        for(SquareX x:allSquareObstacle)
            x.resumeSq();
        for(DoubleCircleX x:allDoubleCircleObstacle)
            x.resumeCir();

        for(CircleInSquareX x : allCircleInSquareObstacle)
            x.resumeCir();
        for(CrossX x : allCrossObstacles)
            x.resumeCir();
        for(SwastikX x : allSwastikObstacles)
            x.resumeCir();
        for(DiamondX x : allDiamondObstacles)
            x.resumeCir();
    }







}