package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Settings {

    @FXML
    private Button SettingsBackButton;
    public void back() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu_front.fxml"));
        Scene reeo = new Scene(root);
        Stage stage = (Stage) SettingsBackButton.getScene().getWindow();
        stage.setScene(reeo);
    }

    @FXML
    private ImageView on,off;

    public void setVolume(){
        if(on.isVisible())
        {
            Main.volume(0);
            on.setVisible(false);
            off.setVisible(true);
            System.out.println("muted");
        }
        else {
            Main.volume(1);
            off.setVisible(false);
            on.setVisible(true);
            System.out.println("unmuted");
        }

    }

    @FXML
    private ColorPicker backgroundPicker;
    @FXML
    private Pane SettingsPane;
    public void setColor()
    {
        BackgroundFill bgfill = new BackgroundFill(backgroundPicker.getValue(), CornerRadii.EMPTY, Insets.EMPTY);
       SettingsPane.setBackground(new Background(bgfill));
//       Main.backgroundColor = new Background(bgfill);
    }
}
