package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple powerup that makes the snake grow TODO make other powerups
public abstract class SimplePowerup extends GameEntity implements Interactable {

    public SimplePowerup(Pane pane) {
        super(pane);
        pane.getChildren().add(this);

        Random rnd = new Random();
        if (Globals.snakeCurrentX < Globals.WINDOW_WIDTH/2){
            setX((0 + Globals.WINDOW_WIDTH/2) *rnd.nextDouble());
        } else {
            setX(Globals.WINDOW_WIDTH/2 + (Globals.WINDOW_WIDTH-Globals.WINDOW_WIDTH/2)*rnd.nextDouble());
        }
        if (Globals.snakeCurrentY < Globals.WINDOW_HEIGHT/2){
            setY(0+Globals.WINDOW_HEIGHT/2 * rnd.nextDouble());
        } else {
            setY(Globals.WINDOW_HEIGHT/2+(Globals.WINDOW_WIDTH-Globals.WINDOW_WIDTH/2)*rnd.nextDouble());
        }
    }


}
