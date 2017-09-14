package com.codecool.snake.entities.enemies;

import com.codecool.snake.Game;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// a simple enemy TODO make better ones.
public abstract class AbstractEnemy extends GameEntity implements Interactable {

    private Point2D heading;
    double direction;
    int speed = 3;
    private static List enemies = new ArrayList<AbstractEnemy>();

    public AbstractEnemy(Pane pane) {
        super(pane);

        pane.getChildren().add(this);

        // Enemy cannot spawn on the snakeHead.
        Random rnd = new Random();
        double xPosition = rnd.nextDouble() * Globals.WINDOW_WIDTH;
        double yPosition = rnd.nextDouble() * Globals.WINDOW_HEIGHT;
        boolean isOnSnakeHead = true;
        while (isOnSnakeHead) {
            if (Game.snakeHead.getBoundsInParent().intersects(this.getBoundsInParent()) ||
                    xPosition < 0 || xPosition > Globals.WINDOW_WIDTH - Globals.simpleEnemy.getWidth() ||
                    yPosition < 0 || yPosition > Globals.WINDOW_HEIGHT - Globals.simpleEnemy.getHeight()) {
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
    }

    public static List getEnemies() { return enemies; }

    public Point2D getHeading() {
        return heading;
    }

    public void setHeading(Point2D heading) {
        this.heading = heading;
    }

    @Override
    public void apply(SnakeHead player) { }

    @Override
    public String getMessage() { return " "; }

    public double getDirection() {
        return direction;
    }

    public void addEnemy(AbstractEnemy enemy){ enemies.add(enemy); }
}
