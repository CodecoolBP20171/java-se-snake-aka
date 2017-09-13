package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;


public class HealthPowerup extends SimplePowerup {

    public HealthPowerup(Pane pane){
        super(pane);
        setImage(Globals.apple);
    }
    @Override
    public void apply(SnakeHead snakeHead){
        if(Globals.getHealth() < 100){
            Globals.setHealth(10);
        }
        destroy();
    }
    @Override
    public String getMessage(){
        return "Got health";
    }
}
