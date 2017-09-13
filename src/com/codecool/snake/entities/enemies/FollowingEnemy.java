package com.codecool.snake.entities.enemies;

import com.codecool.snake.Game;
import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

public class FollowingEnemy extends GameEntity implements Animatable, Interactable{

    private Point2D heading;
    private double direction;
    private int speed = 1;
    public static int enemyCounter = 0;
    public static long startTime;
    private long aliveTime = 0;


    public FollowingEnemy(Pane pane) {
        super(pane);
        startTime = System.currentTimeMillis();

        setImage(Globals.followingEnemy);

        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        direction = 0;
        setRotate(direction);

        pane.getChildren().add(this);
        enemyCounter += 1;
    }


    @Override
    public void step() {
        double directionToSnakeHead = Utils.angleOfLine(getX(), getY(), Game.snakeHead.getX(), Game.snakeHead.getY());
        setRotate(directionToSnakeHead);
        direction = directionToSnakeHead;
        heading = Utils.directionToVector(direction, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
        aliveTime = System.currentTimeMillis() - startTime;
        if (aliveTime > 15000) {
            aliveTime = 0;
            enemyCounter = 0;
            destroy();
        }
    }


        @Override
    public void apply(SnakeHead player) {
            destroy();
            Globals.setHealth(-10);
            enemyCounter = 0;

    }

    @Override
    public String getMessage() {
        return "Snake has been eaten!";
    }

}


