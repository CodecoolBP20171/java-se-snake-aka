package com.codecool.snake;

import com.codecool.snake.entities.enemies.BasicEnemy;
import com.codecool.snake.entities.enemies.FollowingEnemy;
import com.codecool.snake.entities.enemies.AbstractEnemy;
import com.codecool.snake.entities.enemies.PoisonEnemy;
import com.codecool.snake.entities.label.HealthText;
import com.codecool.snake.entities.powerups.BerryPowerup;
import com.codecool.snake.entities.powerups.HealthPowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.popup.Popup;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Game extends Pane {
    public static SnakeHead snakeHead;
    private static int defaultBasicEnemy = 3;


    public Game() {

        setTableBackground(new Image("ezgif.gif"));
        snakeHead = new SnakeHead(this, Globals.STARTING_X, Globals.STARTING_Y);

        for (int basicEnemyNr = 0; basicEnemyNr < defaultBasicEnemy; basicEnemyNr++) {
            createBasicEnemy();
        }

        createBerryPowerUp();
        createHealthPowerUp();
        createHelthText();

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

    public void menu(){ Popup.display(); }

    public void restart(){
        AbstractEnemy.getEnemies().clear();
        Globals.game = new Game();
        Globals.gameObjects.clear();
        Globals.leftKeyDown = false; Globals.rightKeyDown = false;
        Globals.isHealth = false; Globals.isPoison = false;
        Globals.restartHealth(); FollowingEnemy.enemyCounter = 0;
        Globals.resetScore();
        SnakeHead.setSpeed(Globals.defaultSpeed);
        Globals.primaryStage.setScene(new Scene(Globals.game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        Globals.primaryStage.show();
        Globals.popUp.hide();
        Globals.game.start();

    }

    public void createBerryPowerUp(){ new BerryPowerup(this); }

    public void createFollowingEnemy() { new FollowingEnemy(this); }

    public void createHealthPowerUp(){ new HealthPowerup(this); Globals.isHealth = true; }

    public void createPoisonEnemy(){ new PoisonEnemy(this); }

    public void createBasicEnemy(){ new BasicEnemy(this); }

    public void createHelthText(){ new HealthText(this); }

    public void setTableBackground(Image tableBackground) {
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
