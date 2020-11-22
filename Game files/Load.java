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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Load {

    @FXML
    private Button LoadMenu_BackButton;
    @FXML
    private Pane LoadMenuPane;
    public void back() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu_front.fxml"));
        Scene scene = LoadMenu_BackButton.getScene();
        root.translateXProperty().set(scene.getWidth());
        StackPane parent = (StackPane) scene.getRoot();
        parent.getChildren().add(root);
        Timeline timeline1 = new Timeline();
        KeyValue kv1 = new KeyValue(root.translateXProperty(),0, Interpolator.EASE_BOTH);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1),kv1);
        timeline1.getKeyFrames().add(kf1);
        timeline1.setOnFinished(event->{parent.getChildren().remove(LoadMenuPane);});
        timeline1.play();
    }
}
