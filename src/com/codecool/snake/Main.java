package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        Globals.game = game;Globals.primaryStage = primaryStage;
        Globals.primaryStage.setTitle("Snake Game");
        Globals.primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        Globals.primaryStage.show();
        game.start();
    }
}
