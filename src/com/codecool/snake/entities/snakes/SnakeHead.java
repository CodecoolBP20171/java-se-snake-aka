package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class SnakeHead extends GameEntity implements Animatable {

    private static float speed = 2; // must be 2
    private static final float turnRate = 2; // must be 2
    private GameEntity tail; // the last element. Needed to know where to add the next part.

    public SnakeHead(Pane pane, double xc, double yc) {
        super(pane);
        setX(xc);
        setY(yc);
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);

        addPart(4);
    }


    public void step() {
        double dir = getRotate();
        if (Globals.leftKeyDown) {
            dir = dir - turnRate;
        }
        if (Globals.rightKeyDown) {
            dir = dir + turnRate;
        }
        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
        Globals.snakeCurrentX = getX();
        Globals.snakeCurrentY = getY();

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                System.out.println(getBoundsInParent());
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || Globals.getHealth() <= 0) {
            System.out.println("Game Over");
            Globals.gameLoop.stop();
            Globals.game.menu();
        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
    }

    public void changeHealth(int diff) {
        Globals.setHealth(Globals.getHealth() + diff);
    }

    public float getSpeed(){ return speed; }

    public void setSpeed(float speed){ this.speed = speed; }
}
