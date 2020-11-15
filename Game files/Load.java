package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Load {

    @FXML
    public Button LoadMenu_BackButton;
    public void back() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu_front.fxml"));
        Scene reeo = new Scene(root);
        Stage stage = (Stage) LoadMenu_BackButton.getScene().getWindow();
        stage.setScene(reeo);
    }
}
