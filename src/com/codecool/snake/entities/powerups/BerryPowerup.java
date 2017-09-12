package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class BerryPowerup extends SimplePowerup{

    public BerryPowerup(Pane pane){
        super(pane);
        setImage(Globals.powerupBerry);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(4);
        destroy();
        //For testTD only, because later we'll need "bogyó"
        Globals.setScore(Globals.getScore() + 10);
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
