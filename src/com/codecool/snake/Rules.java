package com.codecool.snake;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Rules extends Pane {

    public Rules(){
    }

    public void showRules(Stage primaryStage){


        Globals.rulesScene = new Rules();
        Globals.primaryStage = primaryStage;
        Globals.primaryStage.setTitle("Rules");


        setTableBackground(new Image("rules2.jpg"));
        Scene scene = new Scene(this, Globals.RULES_WINDOW_WIDTH, Globals.RULES_WINDOW_HEIGHT);

        Globals.primaryStage.setScene(scene);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case ENTER:
                        Globals.game = new Game();
                        Globals.game.start();
                        break;
                    case ESCAPE:
                        System.exit(0);
                        break;
                }
            }
        });
        Globals.primaryStage.show();
    }

    public void setTableBackground(Image tableBackground) {
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
