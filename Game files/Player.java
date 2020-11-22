package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Player {

    @FXML
    private Button ResumePlay;
    @FXML
    private Pane InGamePauseMenu;
    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene scene = ResumePlay.getScene();
        root.translateXProperty().set(scene.getWidth());
        StackPane parent = (StackPane) scene.getRoot();
        parent.getChildren().add(root);
        Timeline timeline1 = new Timeline();
        KeyValue kv1 = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1),kv1);
        timeline1.getKeyFrames().add(kf1);
        timeline1.setOnFinished(event->{parent.getChildren().remove(InGamePauseMenu);});
        timeline1.play();
    }


    @FXML
    private Text GameSavedDone;
    public void save(){
        GameSavedDone.setVisible(false);
        System.out.println("Game Saved");
        GameSavedDone.setVisible(true);
    }


    @FXML
    private Button quit;
    public void quitToMainMenu() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu_front.fxml"));
        Scene reeo = new Scene(root);
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.setScene(reeo);
    }
}
