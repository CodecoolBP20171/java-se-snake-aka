package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class BerryPowerup extends AbstractPowerup {

    private static final int extraParts = 4;
    private static final int extraScore = 10;

    public BerryPowerup(Pane pane){
        super(pane);
        setImage(Globals.powerupBerry);
        Globals.setBerryCounter(1);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(extraParts);
        Globals.isHealth = false;
        destroy();
        //For testTD only, because later we'll need "bogyó"
        Globals.setScore(extraScore);
        Globals.game.createBerryPowerUp();
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }


}
