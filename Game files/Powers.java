package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Powers {
    Random random = new Random();
    FileInputStream inputstream;
    ImageView power;
    int powerID;
    boolean visible;
    boolean active;




    public void getPower(Pane root) throws FileNotFoundException {
        powerID = random.nextInt(8);
        switch (powerID)
        {
            case 0:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\starFreq2.png");break;    // inc Star Freq
            case 1:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\noColor2.png");break;     // color Changer will not appear
            case 2:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\magnet2.png");break;      // magnet- stars automatically gets collected
            case 3:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\five2.png");break;        // +5 stars
            case 4:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\double2.png");break;      // x2 stars
            case 5:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\noObstacle2.png");break;  // Obstacles will not appear for some time
            case 6:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\life2.png");break;
            case 7:inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\shield2.png");break;
        }

        Image image = new Image(inputstream);
        power = new ImageView(image);
        power.setTranslateX(165);
        power.setTranslateY(200);
        power.setVisible(true);
        root.getChildren().add(power);
        visible=true;
    }
    public void removePower(){
        power.setVisible(false);
        visible=false;
    }
}
