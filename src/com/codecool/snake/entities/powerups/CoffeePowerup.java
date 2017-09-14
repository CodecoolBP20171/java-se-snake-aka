package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class CoffeePowerup extends AbstractPowerup implements Interactable{

    public CoffeePowerup(Pane pane) {
        super(pane);
        setImage(Globals.powerupCoffee);
    }


    public void apply(SnakeHead snakeHead){
        destroy();
        SnakeHead.setSpeed(SnakeHead.getSpeed()*2);

    }

    @Override
    public String getMessage() {
        return "COFVEFE!";
    }
}
