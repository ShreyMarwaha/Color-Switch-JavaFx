package sample;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class Settings extends Game implements Serializable {


    public void setVolume(ImageView on, ImageView off){
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


    BackgroundFill bgfill = new BackgroundFill(Color.rgb(45,45,45), CornerRadii.EMPTY, Insets.EMPTY);
    public void getColor(ColorPicker cp){
        bgfill = new BackgroundFill(cp.getValue(), CornerRadii.EMPTY, Insets.EMPTY);
    }

    public void setColor(Pane root)
    {
        root.setBackground(new Background(bgfill));
    }



}
