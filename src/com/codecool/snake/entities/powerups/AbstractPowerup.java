package com.codecool.snake.entities.powerups;

import com.codecool.snake.Game;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import javafx.scene.layout.Pane;

import java.util.concurrent.ThreadLocalRandom;

// a simple powerup that makes the snake grow TODO make other powerups
public abstract class AbstractPowerup extends GameEntity implements Interactable {

    public AbstractPowerup(Pane pane) {
        super(pane);
        pane.getChildren().add(this);

        if (Game.snakeHead.getX() < Globals.WINDOW_WIDTH/2){
            setX(ThreadLocalRandom.current().nextDouble(Globals.WINDOW_WIDTH/2, (Globals.WINDOW_WIDTH-Globals.powerupBerry.getWidth())));
        } else {
            setX(ThreadLocalRandom.current().nextDouble(0, Globals.WINDOW_WIDTH/2));
        }
        if (Game.snakeHead.getY() < Globals.WINDOW_HEIGHT/2){
            setY(ThreadLocalRandom.current().nextDouble(Globals.WINDOW_HEIGHT/2, (Globals.WINDOW_HEIGHT-Globals.powerupBerry.getHeight())));
        } else {
            setY(ThreadLocalRandom.current().nextDouble(0, Globals.WINDOW_HEIGHT/2));
        }
    }


}
