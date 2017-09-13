package com.codecool.snake.entities.enemies;

import com.codecool.snake.Game;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// a simple enemy TODO make better ones.
public class SimpleEnemy extends GameEntity implements Animatable, Interactable {
    private Point2D heading;
    private static final int damage = 10;
    double direction;
    int speed = 3;
    private static List enemies = new ArrayList<SimpleEnemy>();

    public SimpleEnemy(Pane pane) {
        super(pane);

        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);

        // Enemy cannot spawn on the snakeHead.
        Random rnd = new Random();
        double xPosition = rnd.nextDouble() * Globals.WINDOW_WIDTH;
        double yPosition = rnd.nextDouble() * Globals.WINDOW_HEIGHT;

        boolean isOnSnakeHead = true;
        while (isOnSnakeHead) {
            if (Game.snakeHead.getBoundsInParent().intersects(this.getBoundsInParent())) {
                xPosition = rnd.nextDouble() * Globals.WINDOW_WIDTH;
                yPosition = rnd.nextDouble() * Globals.WINDOW_HEIGHT;
            } else {
                isOnSnakeHead = !isOnSnakeHead;
            }
        }
        setX(xPosition);
        setY(yPosition);

        this.direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
        enemies.add(this);
    }

    public static List getEnemies() {
        return enemies;
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            if (getX() < 0 || getX() > (Globals.WINDOW_WIDTH-Globals.simpleEnemy.getWidth())) {
                this.direction = 360 - getDirection();
                heading = Utils.directionToVector(direction, speed);
            } else if (getY() < 0 || getY() > (Globals.WINDOW_HEIGHT-Globals.simpleEnemy.getHeight())) {
                if (getDirection() >= 180) {
                    this.direction = 360 - getDirection() + 180;
                    heading = Utils.directionToVector(direction, speed);
                } else {
                    this.direction = 180 - getDirection();
                    heading = Utils.directionToVector(direction, speed);
                }
            } else {}
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        Globals.setHealth(-20);
        destroy();
        enemies.remove(this);
        if (enemies.size() <=2){
            SimpleEnemy enemy = new SimpleEnemy(pane);
        }
    }

    @Override
    public String getMessage() {
        return "20 damage";
    }

    public double getDirection() {
        return direction;
    }
}
