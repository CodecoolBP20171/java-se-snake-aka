package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    private static int score = 0;
    public static boolean isPoison;
    public static boolean isHealth;
    private static int health = 100;
    private static int berryCounter = 0;
    public static final int maxHealth = 100;
    public static final int defaultSpeed = 2;
    private static final int fullHealth = 100;
    public static final int defaultWaitTime = 15000;
    public static final int nextHealthPowerUpTurn = 10;


    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;

    public static final double STARTING_X = WINDOW_WIDTH/2;
    public static final double STARTING_Y = WINDOW_HEIGHT/2;

    public static Image snakeHead = new Image("snake_head.png");
    public static Image snakeBody = new Image("snake_body.png");
    public static Image simpleEnemy = new Image("simple_enemy.png");
    public static Image powerupBerry = new Image("powerup_berry.png");
    public static Image poisonEnemy = new Image("powerup_poison.png");
    public static Image apple = new Image("apple-icon.png");
    public static Image powerupCoffee = new Image("java-cofvefe.png");
    public static Image followingEnemy = new Image("following_enemy.png");

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;
    public static Stage primaryStage;public static Stage popUp;
    public static Game game;

    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
    }

    public static int getBerryCounter() { return berryCounter; }

    public static void setBerryCounter(int berryCounter) { Globals.berryCounter += berryCounter; }

    public static int getHealth() { return health; }

    public static void setHealth(int health) { Globals.health += health; }
    public static void restartHealth(){ Globals.health = fullHealth; }

    public static void setScore(int score) { Globals.score = Globals.getScore() + score; }

    public static int getScore() { return score; }

    public static void resetScore(){ Globals.score = 0;}

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }
}
