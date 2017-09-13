package com.codecool.snake;

import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.label.HealthText;
import com.codecool.snake.entities.powerups.BerryPowerup;
import com.codecool.snake.entities.powerups.PoisonPowerUp;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.popup.Popup;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {

        SnakeHead snakeHead = new SnakeHead(this, Globals.STARTING_X, Globals.STARTING_Y);

        // Refactor (put into a for loop....)
        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);

        // Refactor (put into a for loop....)
        new PoisonPowerUp(this);
        new BerryPowerup(this);

        new HealthText(this);



    }

    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
            }
        });
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }

    public void menu(){
        Popup.display();

    }

    public void restart(){

        Globals.game = new Game();
        Globals.gameObjects.clear();
        Globals.primaryStage.setScene(new Scene(Globals.game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        Globals.primaryStage.show();
        Globals.popUp.hide();
        Globals.game.start();

    }
}
