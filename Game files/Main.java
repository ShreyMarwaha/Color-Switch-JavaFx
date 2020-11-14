package sample;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.stage.*;

public class Main extends Application {
    public static void main(String[] args) {launch(args);}

    Stage Window;
//    Scene Scene1, Scene2;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Window = primaryStage;
        Window.setOnCloseRequest(e-> { e.consume();  Quit();}   );
        Window.setScene(new Scene(root));
        Window.setTitle("Color Switch | Shrey Marwaha | Arnav Gupta");
        Window.show();

    }

    public void NewGame(){
//        TODO: method to START New Game
        System.out.println("new Game started");

    }

    public void ResumeGame(){
//        TODO: method to START New Game
        System.out.println("game resumed");

    }

//    ArrayList<> SavedGames = new ArrayList<>();
    public void LoadGame(){
//        TODO: method for laoding game from arraylist
    }


    @FXML
    public Button closeButton;
    public void Quit()
    {
//          TODO: a method to SAVE CURRENT GAME FILE for RESUME GAME button
        //save()
        System.out.println("exitting...");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        System.out.println("game quit successfully");
    }
}
