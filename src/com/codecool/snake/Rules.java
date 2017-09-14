package com.codecool.snake;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Rules extends Pane {

    public Rules(){
    }

    public void showRules(Stage primaryStage){
        setTableBackground(new Image("rules.jpg"));
        ImageView buttonView = new ImageView(Globals.startButton);
        Globals.rulesScene = new Rules();
        Globals.primaryStage = primaryStage;
        Globals.primaryStage.setTitle("Rules");
        Button startButton = new Button("", buttonView);
        Globals.primaryStage.setScene(new Scene(startButton, Globals.RULES_WINDOW_WIDTH, Globals.RULES_WINDOW_HEIGHT));
        Globals.primaryStage.show();
        startButton.setOnAction(actionEvent -> {
            Globals.game = new Game();
            Globals.game.start();
        });
    }

    public void setTableBackground(Image tableBackground) {
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
