package sample;

import javafx.scene.Group;
import java.io.Serializable;
import java.util.Random;

public class Shape extends Game{
    Random random = new Random();
    Shape obstacle;
    public Group generateObstacle()
    {
        int i = random.nextInt(6);

        switch (i) {
            case 0: {
                CircleX obs = new CircleX();
                obstacle = obs;
                allCircleObstacle.add(obs);
                return obs.obstacleGroup;
            }
            case 1: {
                SquareX obs = new SquareX();
                obstacle = obs;
                allSquareObstacle.add(obs);
                return  obs.obstacleGroup;
            }
            case 2: {
                LineX obs = new LineX();
                obstacle = obs;
                allLineObstacle.add(obs);
                return  obs.obstacleGroup;
            }
            case 3: {
                DoubleCircleX obs = new DoubleCircleX();
                obstacle = obs;
                allDoubleCircleObstacle.add(obs);
                return  obs.obstacleGroup;
            }
            case 4: {
                CircleInSquareX obs = new CircleInSquareX();
                obstacle = obs;
                allCircleInSquareObstacle.add(obs);
                return  obs.obstacleGroup;
            }
            case 5:
            {
                CrossX obs = new CrossX();
                obstacle = obs;
                allCrossObstacles.add(obs);
                return obs.obstacleGroup;
            }
            case 6:
            {
                SwastikX obs = new SwastikX();
                obstacle = obs;
//                allSwastikObstacles.add(obs);
                return obs.obstacleGrp;
            }
            case 7:
            {
                DiamondX obs = new DiamondX();
                obstacle = obs;
                allDiamondObstacles.add(obs);
                return obs.obstacleGrp;
            }

        }
        return null;
    }
}
