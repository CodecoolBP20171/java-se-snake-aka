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

public class FollowingEnemy extends AbstractEnemy implements Animatable{

    private Point2D heading;
    private double direction;
    private int speed = 1;
    public static int enemyCounter = 0;
    public static long startTime;
    private long aliveTime = 0;
    private static final int damage = -10;


    public FollowingEnemy(Pane pane) {
        super(pane);
        startTime = System.currentTimeMillis();

        setImage(Globals.followingEnemy);
        enemyCounter++;
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
        if (aliveTime > Globals.defaultWaitTime) {
            aliveTime = 0;
            enemyCounter = 0;
            destroy();
        }
    }


    @Override
    public void apply(SnakeHead player) {
            destroy();
            Globals.setHealth(damage);
            enemyCounter = 0;

    }

    @Override
    public String getMessage() {
        return "Snake has been eaten!";
    }

}


