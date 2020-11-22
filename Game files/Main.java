package sample;

import com.sun.javafx.scene.SceneEventDispatcher;
import javafx.animation.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.util.Duration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Time;

import static javafx.scene.paint.Color.rgb;

public class Main extends Application {

    static AudioClip mediaPlayer;
    public void music(double vol) {
//        TODO: make media portable playable by not specifying the path
        try {
            mediaPlayer = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/music.mp3");
            mediaPlayer.setCycleCount(30);
            volume(vol);
            System.out.println("meadia file ready");
        }
        catch (Exception e) {
            System.out.println("media file not found");
        }
    }

    static void volume(double vol)
    {
        mediaPlayer.stop();
        mediaPlayer.setVolume(vol);
        mediaPlayer.play();
        System.out.println("volume updated");
    }
    public static void main(String[] args) {launch(args);}

    @FXML
    ImageView SettingImg;
    @FXML
    ImageView mainBG;
    @FXML
    StackPane spain;
    @FXML
    Pane MPain;
    @FXML
    Node cr1;
    @FXML
    Node cr2;
    @FXML
    Node cr3;
    @FXML
    Node crs4;
    @FXML
    Node crs5;
    Stage Window;
    @Override
    public void start(Stage primaryStage) throws Exception{

        music(1);
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu_front.fxml"));
        Window = primaryStage;
        Window.setScene(new Scene(root));
        Window.setTitle("Color Switch | Shrey Marwaha | Arnav Gupta");
        Window.initStyle(StageStyle.UNDECORATED);
        Window.show();
    }

    RotateTransition rotate1,rotate2,rotate3,rotate4, rotate5;
    public void rotate(){
        rotate4 = new RotateTransition(Duration.seconds(0.2),crs4);
        rotate4.setByAngle(-360);
        rotate4.setCycleCount(Animation.INDEFINITE);
        rotate4.setInterpolator(Interpolator.LINEAR);
        rotate4.play();

        rotate5 = new RotateTransition(Duration.seconds(0.2),crs5);
        rotate5.setByAngle(-360);
        rotate5.setCycleCount(Animation.INDEFINITE);
        rotate5.setInterpolator(Interpolator.LINEAR);
        rotate5.play();

        rotate1 = new RotateTransition(Duration.seconds(3),cr1);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(Animation.INDEFINITE);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.play();
        rotate2 = new RotateTransition(Duration.seconds(7),cr2);
        rotate2.setByAngle(-360);
        rotate2.setCycleCount(Animation.INDEFINITE);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.play();
        rotate3 = new RotateTransition(Duration.seconds(1),cr3);
        rotate3.setByAngle(360);
        rotate3.setCycleCount(Animation.INDEFINITE);
        rotate3.setInterpolator(Interpolator.LINEAR);
        rotate3.play();
        System.out.println("in here boys");

    }
    public void rotateStop(){
        rotate1.stop();
        rotate2.stop();
        rotate3.stop();
    }




    @FXML
    private Button NewGameButton;
    public void NewGame() throws IOException {
//        TODO: method to START New Game
        Game game = new Game();
//        game.setBackground(backgroundColor);

        System.out.println("new Game");
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene scene = NewGameButton.getScene();
        root.translateYProperty().set(-scene.getHeight());
        spain.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.1),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event->{spain.getChildren().remove(MPain);});
        timeline.play();
        System.out.println("new Game started");

    }


    public void ResumeGame() throws IOException {
//        TODO: method to START New Game
        //reload()
        System.out.println("game resumed");
        NewGame();
    }

    @FXML
    ImageView playButton;
    @FXML
    Circle bgWhiteCircle;
    public void setVisible(){
        if(!playButton.isVisible()) {
            playButton.setVisible(true);
            bgWhiteCircle.setVisible(true);
            bgWhiteCircle.radiusProperty().set(0);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(bgWhiteCircle.radiusProperty(), 110, Interpolator.LINEAR);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.8), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
        }
    }

    public void setInVisible()
    {
        if(playButton.isVisible()) {
            bgWhiteCircle.radiusProperty().set(110);
            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(bgWhiteCircle.radiusProperty(), 0, Interpolator.EASE_OUT);
            KeyFrame kf = new KeyFrame(Duration.seconds(0.5), kv);
            timeline.getKeyFrames().add(kf);
            timeline.play();
            playButton.setVisible(false);
        }
    }

    @FXML
    public Button LoadMenuButton;
//    ArrayList<> SavedGames = new ArrayList<>();
    public void LoadGame() throws IOException {
//        TODO: method for laoding game from arraylist
        Parent root = FXMLLoader.load(getClass().getResource("Menu_LoadGame.fxml"));

        Scene LoadMenu = LoadMenuButton.getScene();
        root.translateXProperty().set(-LoadMenu.getWidth());
        spain.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event->{spain.getChildren().remove(MPain);});
        timeline.play();
        System.out.println("laod menu");
    }

    @FXML
    public Button closeButton;
    public void Quit()
    {
//          TODO: a method to SAVE CURRENT GAME FILE for RESUME GAME buttonX (automatic save current before exit)
        //save()
        System.out.println("exitting...");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        System.out.println("game quit successfully");
    }

    @FXML
    public Button SettingsButton;
    public void Settings() throws IOException {
        System.out.println("settings");
        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));

        Scene Settings = SettingsButton.getScene();
        root.translateYProperty().set(Settings.getHeight());
        spain.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.5),kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event->{spain.getChildren().remove(MPain);});
        timeline.play();
    }
}
