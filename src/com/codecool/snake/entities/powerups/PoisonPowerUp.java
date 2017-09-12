package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class PoisonPowerUp extends SimplePowerup{

    public PoisonPowerUp(Pane pane){
        super(pane);
        setImage(Globals.powerupPoison);
    }

    @Override
    public void apply(SnakeHead snakeHead){
        // health -= 5
        destroy();
    }

    @Override
    public String getMessage(){
        return "You got poisoned!";
    }
}
