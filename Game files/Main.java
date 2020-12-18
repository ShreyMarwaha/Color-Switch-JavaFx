package sample;

import javafx.animation.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.util.Duration;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;


public class Main extends Application {

    static AudioClip mediaPlayer;
    static boolean loaded=false;

    public void LoadMyGame(AtomicReference<String> filename)
    {
        FileInputStream file = null;
        try
        {
            file = new FileInputStream(String.valueOf(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Method for deserialization of object
        try {
            assert in != null;
            loaded = true;
            Game temp = (Game)in.readObject();
            int prev = temp.ball.prev;
            game = new Game();
            game.points = temp.points;
            if(prev==0)
                game.ball.setColor(Color.DEEPPINK);
            else if(prev==1)
                game.ball.setColor(Color.YELLOW);
            else if(prev==2)
                game.ball.setColor(Color.CYAN);
            else
                game.ball.setColor(Color.DARKVIOLET);


        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            assert file != null;
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public void SaveMyGame(AtomicReference<String> manualSaveFilename){
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(String.valueOf(manualSaveFilename));
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(game);

            out.close();
            file.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        String filename = "file.ser";
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(game);

            out.close();
            file.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {launch(args);}
    Stage Window;
    Shape shape;
    Group obstacleGrp;
    Pane root2;
    transient ImageView colorChanger;
    transient ImageView star, cross,ON, OFF, powerOnScreen,backButton;
    Text starCollectedText = new Text("0");
    Game game;




    @Override
    public void start(Stage primaryStage) throws Exception{
        Window = primaryStage;
        music(1);
        StackPane root = FXMLLoader.load(getClass().getResource("MainMenu_front.fxml"));
        Scene HomeScene = new Scene(root);
        Window.setScene(HomeScene);
        Window.initStyle(StageStyle.UNDECORATED);

        Button ResumeButton = new Button("RESUME");
        Button NewGameButton = new Button("NEW GAME");
        Button LoadGameButton = new Button("LOAD GAME GAME");


        Settings settings = new Settings();

//        *** IMAGES/ICONS ***
        FileInputStream inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\settings.png");
        Image image = new Image(inputstream);
        ImageView settingsIcon = new ImageView(image);
        settingsIcon.setTranslateX(160);
        settingsIcon.setTranslateY(-290);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\trophy.png");
        image = new Image(inputstream);
        ImageView trophy = new ImageView(image);
        trophy.setTranslateX(-160);
        trophy.setTranslateY(-290);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\ColorChanger.png");
        image = new Image(inputstream);
        colorChanger = new ImageView(image);
        colorChanger.setVisible(false);
        colorChanger.setTranslateX(175);
        colorChanger.setTranslateY(300);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\on.png");
        image = new Image(inputstream);
        ON = new ImageView(image);
        ON.setFitWidth(32);
        ON.setPreserveRatio(true);
        ON.setTranslateX(50);
        ON.setTranslateY(-50);


        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\off.png");
        image = new Image(inputstream);
        OFF = new ImageView(image);
        OFF.setVisible(false);
        OFF.setTranslateX(50);
        OFF.setTranslateY(-50);
        OFF.setFitWidth(32);
        OFF.setPreserveRatio(true);

        ON.setOnMouseClicked(e->settings.setVolume(ON,OFF));
        OFF.setOnMouseClicked(e->settings.setVolume(ON,OFF));

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\star32.png");
        image = new Image(inputstream);
        star = new ImageView(image);
        star.setVisible(false);
        star.setTranslateX(175);
        star.setTranslateY(200);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\star32.png");
        image = new Image(inputstream);
        powerOnScreen = new ImageView(image);
        powerOnScreen.setVisible(false);
        powerOnScreen.setTranslateX(175);
        powerOnScreen.setTranslateY(200);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\star.png");
        image = new Image(inputstream);
        ImageView starPointBg = new ImageView(image);
        starPointBg.setTranslateX(10);
        starPointBg.setTranslateY(10);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\pauseMenu.png");
        image = new Image(inputstream);
        ImageView pauseMenu = new ImageView(image);
        pauseMenu.setTranslateX(325);
        pauseMenu.setTranslateY(10);
        pauseMenu.setPreserveRatio(true);
        pauseMenu.setFitWidth(44);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\game-over.png");
        image = new Image(inputstream);
        ImageView gameOver = new ImageView(image);
        gameOver.setTranslateY(-175);
        gameOver.setEffect(new DropShadow(20, Color.BLACK));

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\grave.png");
        image = new Image(inputstream);
        ImageView grave = new ImageView(image);
        grave.setTranslateY(75);

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\crossButton.png");
        image = new Image(inputstream);
        cross = new ImageView(image);
        cross.setTranslateX(-160);
        cross.setTranslateY(-280);
        cross.setOnMouseClicked(e1-> {
            primaryStage.setScene(HomeScene);
//            game.resumeGame();
        });

        inputstream = new FileInputStream("C:\\Users\\marwahnk\\Desktop\\Color Switch\\src\\sample\\previous.png");
        image = new Image(inputstream);
        backButton = new ImageView(image);
        backButton.setTranslateX(-160);
        backButton.setTranslateY(-290);

        starCollectedText.setX(35);
        starCollectedText.setY(52);
        starCollectedText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

//        *** IMAGES/ICON (END) ***

        //modifs to BUTTON
        NewGameButton.setTranslateY(175);
        ResumeButton.setTranslateY(215);
        LoadGameButton.setTranslateY(253);
        HomeScene.getStylesheets().add("sample/Styles.css");


        //NEW GAME
        NewGameButton.setOnAction(e-> {
            root2 = new Pane();
            Scene NewGameScene = new Scene(root2,380,644);
            System.out.println("New Game");

            settings.setColor(root2);
            primaryStage.setScene(NewGameScene);
            if(!loaded)
                game = new Game();

            shape = new Shape();
            obstacleGrp = shape.generateObstacle();

            game.ball.initial = game.ball.ball.getCenterY();
            starCollectedText.setText(Integer.toString(game.points));

            AnimationTimer timer = new myTimer();
            timer.start();
            root2.getChildren().addAll(game.ball.rect, game.ball.ball, obstacleGrp,colorChanger,star,starPointBg,starCollectedText,pauseMenu);

            pauseMenu.setOnMouseClicked(e1->{
                game.pauseGame();
                System.out.println("pause menu");

                Text SaveGameConf = new Text("Game Saved!");
                SaveGameConf.setFill(Color.GREEN);
                SaveGameConf.setTranslateY(190);
                SaveGameConf.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

                SaveGameConf.setVisible(false);

                StackPane root5 = new StackPane();
                settings.setColor(root5);
                Scene PauseMenuScene = new Scene(root5,380,644);
                PauseMenuScene.getStylesheets().add("sample/Styles.css");
                primaryStage.setScene(PauseMenuScene);
                Text PauseMenuText = new Text("Pause Menu");
                PauseMenuText.setFill(Color.WHITE);
                PauseMenuText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
                PauseMenuText.setTranslateY(-200);

                Button SaveGameButton = new Button("Save Game");
                SaveGameButton.setTranslateY(-50);
                SaveGameButton.setOnAction(e2-> {
                    SaveGameConf.setVisible(false);
                    Pane root7 = new StackPane();
                    Scene SaveGameScene = new Scene(root7,380,644);
                    SaveGameScene.getStylesheets().add("sample/Styles.css");

                    primaryStage.setScene(SaveGameScene);
                    Text choose = new Text("SAVE GAME");
                    choose.setFill(Color.WHITE);
                    choose.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
                    choose.setTranslateY(-250);

                    AtomicReference<String> manualSaveFilename = new AtomicReference<>(".ser");
                    Button b1 = new Button("game1");
                    b1.setTranslateY(-150);
                    b1.setOnAction(e3-> {
                        manualSaveFilename.set(b1.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });
                    Button b2 = new Button("game2");
                    b2.setTranslateY(-100);
                    b2.setOnAction(e3-> {
                        manualSaveFilename.set(b2.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b3 = new Button("game3");
                    b3.setTranslateY(-50);
                    b3.setOnAction(e3-> {
                        manualSaveFilename.set(b3.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b4 = new Button("game4");
                    b4.setOnAction(e3-> {
                        manualSaveFilename.set(b4.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b5 = new Button("game5");
                    b5.setTranslateY(50);
                    b5.setOnAction(e3-> {
                        manualSaveFilename.set(b5.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b6 = new Button("game6");
                    b6.setTranslateY(100);
                    b6.setOnAction(e3-> {
                        manualSaveFilename.set(b6.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b7 = new Button("game7");
                    b7.setTranslateY(150);
                    b7.setOnAction(e3-> {
                        manualSaveFilename.set(b7.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b8 = new Button("game8");
                    b8.setTranslateY(200);
                    b8.setOnAction(e3-> {
                        manualSaveFilename.set(b8.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b9 = new Button("game9");
                    b9.setTranslateY(250);
                    b9.setOnAction(e3-> {
                        manualSaveFilename.set(b9.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });

                    Button b10 = new Button("game10");
                    b10.setTranslateY(300);
                    b10.setOnAction(e3-> {
                        manualSaveFilename.set(b10.getText() + manualSaveFilename);
                        SaveMyGame(manualSaveFilename);
                        SaveGameConf.setVisible(true);
                        choose.setFill(Color.GREEN);

                    });


                    backButton.setOnMouseClicked(e3->{
                       primaryStage.setScene(PauseMenuScene);
                    });
                    root7.getChildren().addAll(choose,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,SaveGameConf,backButton);

                });

                Button QuitGame = new Button("Quit Game");
                QuitGame.setOnAction(e2-> primaryStage.close());

                Button Resume = new Button("Resume");
                Resume.setTranslateY(50);
                Resume.setOnAction(e2->
                {
                    primaryStage.setScene(NewGameScene);
                    game.resumeGame();
                });

                root5.getChildren().addAll(SaveGameButton,QuitGame,Resume,SaveGameConf,PauseMenuText);
            });

            NewGameScene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.SPACE) {
                    System.out.println("key pressed JUMP!");
                    game.ball.timeE = 0;
                    game.ball.acceleration = 9;
                    game.ball.velocity = 5;
                }
                else if(keyEvent.getCode() == KeyCode.DOWN)
                {
                    System.out.println("Collision");
                    game.pauseGame();
                    music(0);
                    if(game.points==0)
                    {
                        AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/coffinDance.mp3");
                        gameOverBeats.play();
                    }
                    else {
                        AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/GameOverBeats.mp3");
                        gameOverBeats.play();

                        gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/gameOverSound.mp3");
                        gameOverBeats.play();
                    }

                    Pane root6 = new StackPane();
                    settings.setColor(root6);
                    Scene GameOverScene = new Scene(root6,380,644);
                    GameOverScene.getStylesheets().add("sample/Styles.css");
                    primaryStage.setScene(GameOverScene);

                    Button QuitGame = new Button("Quit Game");
                    QuitGame.setOnAction(e2->primaryStage.close());
                    QuitGame.setTranslateY(170);
                    root6.getChildren().addAll(grave, gameOver,QuitGame);
                }
            });
        });


        Pane root3 = new StackPane();
        Scene LoadGameScene = new Scene(root3,380,644);
        LoadGameScene.getStylesheets().add("sample/Styles.css");


        LoadGameButton.setOnAction(e->{
            primaryStage.setScene(LoadGameScene);

            Text loadGameText = new Text("LOAD GAME");
            loadGameText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
            loadGameText.setFill(Color.WHITE);
            loadGameText.setTranslateY(-250);
            System.out.println("Load game");
            settings.setColor(root3);


            AtomicReference<String> manualSaveFilename = new AtomicReference<>(".ser");

            Button b1 = new Button("game1");
            b1.setTranslateY(-150);
            b1.setOnAction(e3-> {
                manualSaveFilename.set(b1.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b2 = new Button("game2");
            b2.setTranslateY(-100);
            b2.setOnAction(e3-> {
                manualSaveFilename.set(b2.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });


            Button b3 = new Button("game3");
            b3.setTranslateY(-50);
            b3.setOnAction(e3-> {
                manualSaveFilename.set(b3.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b4 = new Button("game4");
            b4.setOnAction(e3-> {
                manualSaveFilename.set(b4.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b5 = new Button("game5");
            b5.setTranslateY(50);
            b5.setOnAction(e3-> {
                manualSaveFilename.set(b5.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b6 = new Button("game6");
            b6.setTranslateY(100);
            b6.setOnAction(e3-> {
                manualSaveFilename.set(b6.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b7 = new Button("game7");
            b7.setTranslateY(150);
            b7.setOnAction(e3-> {
                manualSaveFilename.set(b7.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b8 = new Button("game8");
            b8.setTranslateY(200);
            b8.setOnAction(e3-> {
                manualSaveFilename.set(b8.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b9 = new Button("game9");
            b9.setTranslateY(250);
            b9.setOnAction(e3-> {
                manualSaveFilename.set(b9.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                }
            });

            Button b10 = new Button("game10");
            b10.setTranslateY(300);
            b10.setOnAction(e3-> {
                manualSaveFilename.set(b10.getText() + manualSaveFilename);
                try {
                    LoadMyGame(manualSaveFilename);
                } catch (Exception ex) {
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/nope.mp3");
                    gameOverBeats.play();
                    ex.printStackTrace();
                }
            });





            root3.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,loadGameText,cross);


        });

        Pane root4 = new StackPane();
        Scene SettingsScene = new Scene(root4,380,644);

        settingsIcon.setOnMouseClicked(e->{
            primaryStage.setScene(SettingsScene);
            Text settingsText = new Text("SETTINGS");
            settingsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
            settingsText.setTranslateY(-200);

            Text musicText = new Text("MUSIC");
            musicText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            musicText.setTranslateX(-100);
            musicText.setTranslateY(-50);

            Text backgroundText = new Text("BACKGROUND");
            backgroundText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            backgroundText.setTranslateX(-65);
            backgroundText.setTranslateY(100);

            ColorPicker colorPicker = new ColorPicker();
            colorPicker.setValue(Color.rgb(45,45,45));
            colorPicker.setTranslateY(100);
            colorPicker.setTranslateX(100);

            colorPicker.setOnAction(e1->{
                settings.getColor(colorPicker);
                settings.setColor(root4);
            });

            root4.getChildren().addAll(cross, settingsText, musicText, backgroundText, ON, OFF, colorPicker);

        });












        root.getChildren().addAll(ResumeButton,NewGameButton,LoadGameButton,settingsIcon,trophy);
        Window.show();
    }


    int counter=0;
    int starFreq = 1000;
    Powers power = new Powers();
    int powerTimer=0;
    int powerActiveTimer=0;

    private class myTimer extends AnimationTimer {
        @Override
        public void handle(long e)
        {
            if(power.visible) {
                powerTimer--;
                if(powerTimer==0)
                    power.removePower();
            }

            if(!game.pause) {
                counter++;
                double v = game.ball.velocity - game.ball.acceleration * game.ball.timeE;
                game.ball.timeE += 0.02;
                game.ball.distance = game.ball.velocity * game.ball.timeE - game.ball.acceleration * game.ball.timeE * game.ball.timeE * 0.5;
                double centre = game.ball.ball.getCenterY();

                if ((centre > 300 - 6 && v < 0) || centre > 300)
                    game.ball.ball.setCenterY(300 - 3);

                else
                    game.ball.ball.setCenterY(game.ball.ball.getCenterY() - game.ball.distance);

                game.ball.ball.setTranslateY(game.ball.ball.getCenterY());

                if (counter % 700 == 0 && !(power.active && power.powerID==5)) {
                    obstacleGrp = shape.generateObstacle();
                    root2.getChildren().addAll(obstacleGrp);
                }

                if (counter % 1555 == 0 && !colorChanger.isVisible())
                    colorChanger.setVisible(true);


                if (counter % starFreq == 0)
                    star.setVisible(true);

                if (colorChanger.isVisible() && game.ball.ball.getCenterY() < 160 && game.ball.ball.getCenterY() > 140) {
                    System.out.println("change color");
                    colorChanger.setVisible(false);
                    if (!(power.active && power.powerID == 1)) {
                        game.ball.changeColor();
                    }
                }

                if ((star.isVisible() && game.ball.ball.getCenterY() < 110 && game.ball.ball.getCenterY() > 90) || (star.isVisible() && power.active && power.powerID==2)) {
                    System.out.println("star");
                    star.setVisible(false);
                    game.points++;
                    starCollectedText.setText(Integer.toString(game.points));
                    AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/coin.mp3");
                    gameOverBeats.play();
                }

                if(power.visible && game.ball.ball.getCenterY()<110 && game.ball.ball.getCenterY()>90)
                {
                    System.out.println("POWER GAINED");
                    power.active=true;
                    power.removePower();
                    powerActiveTimer=2000;
                    if(power.powerID<8) {
                        AudioClip gameOverBeats = new AudioClip("file:///C:/Users/marwahnk/Desktop/Color%20Switch/src/sample/yeahBoy.mp3");
                        gameOverBeats.play();
                    }
                    if(power.powerID==7) {
                        game.ball.ball.setStrokeWidth(4);
                    }

                }

                if (counter%1345==0 && !power.visible && !power.active)
                {
                    try {
                        power.getPower(root2);
                        System.out.println("power");
                        powerTimer=250;
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }

                if(power.active)
                {
                    switch (power.powerID)
                    {
                        case 0: starFreq = 200; break;

                        case 3:{
                            System.out.println("+5 stars");
                            game.points = game.points+5;
                            starCollectedText.setText(Integer.toString(game.points));
                            powerActiveTimer=0;
                            power.active = false;
                            break;
                        }
                        case 4:{
                            System.out.println("double stars");
                            game.points*=2;
                            starCollectedText.setText(Integer.toString(game.points));
                            powerActiveTimer=0;
                            break;
                        }



                    }
                    powerActiveTimer--;
                    if(powerActiveTimer<=0) {
                        power.active = false;
                        starFreq=1000;
                        game.ball.ball.setStrokeWidth(0);
                    }
                }
            }



        }
    }




    @FXML
    transient public Button closeButton;
    public void Quit()
    {
//          TODO: a method to SAVE CURRENT GAME FILE for RESUME GAME buttonX (automatic save current before exit)
        //save()
        System.out.println("exitting...");
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        System.out.println("game quit successfully");
    }



//    ***HELPER FUNCTIONS***
    transient RotateTransition rotate1,rotate2,rotate3,rotate4, rotate5;
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
        System.out.println("play button");

    }
    public void rotateStop(){
        rotate1.stop();
        rotate2.stop();
        rotate3.stop();
    }

    @FXML
    transient ImageView playButton;
    @FXML
    transient Circle bgWhiteCircle;
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

    @FXML
    transient private Node cr1;
    @FXML
    transient private Node cr2;
    @FXML
    transient private Node cr3;
    @FXML
    transient private Node crs4;
    @FXML
    transient private Node crs5;


}
