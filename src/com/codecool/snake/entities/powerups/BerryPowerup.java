package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.enemies.PoisonEnemy;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class BerryPowerup extends AbstractPowerup {

    private static final int extraParts = 4;
    private static final int extraScore = 10;
    private static final int nextStage = 150;
    private static final int nextHealthPowerUpTurn = 10;

    public BerryPowerup(Pane pane){
        super(pane);
        setImage(Globals.powerupBerry);
        Globals.setBerryCounter(1);
        if(Globals.getBerryCounter() % nextHealthPowerUpTurn == 0){
            new HealthPowerup(pane);
        }
        if (Globals.getScore() % nextStage == 0 || Globals.getScore() % nextStage == 5){ //belenyúltam, elvileg így jó
            new PoisonEnemy(pane);
        }
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(extraParts);
        destroy();
        //For testTD only, because later we'll need "bogyó"
        Globals.setScore(extraScore);
        new BerryPowerup(pane);
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }


}
