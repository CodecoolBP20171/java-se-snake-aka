package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

import static com.codecool.snake.Globals.rulesScene;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Globals.rulesScene = new Rules();
        Globals.rulesScene.showRules(primaryStage);
        Globals.primaryStage.show();
    }

    public void startGame(Stage primaryStage) {
        Globals.game = new Game();
        Globals.primaryStage.setTitle("Snake Game");
        Globals.primaryStage.setScene(new Scene(Globals.game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        Globals.primaryStage.show();
        Globals.game.start();
    }
}
