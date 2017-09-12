package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple enemy TODO make better ones.
public class SimpleEnemy extends GameEntity implements Animatable, Interactable {

    private Point2D heading;
    private static final int damage = 10;
    double direction;
    int speed = 3;

    public SimpleEnemy(Pane pane) {
        super(pane);

        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        this.direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
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
        Globals.setHealth(-10);
        destroy();
    }

    @Override
    public String getMessage() {
        return "10 damage";
    }

    public double getDirection() {
        return direction;
    }
}
