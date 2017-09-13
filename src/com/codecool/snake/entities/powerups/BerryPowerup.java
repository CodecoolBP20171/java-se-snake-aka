package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.enemies.PoisonEnemy;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class BerryPowerup extends SimplePowerup{

    public BerryPowerup(Pane pane){
        super(pane);
        setImage(Globals.powerupBerry);
        Globals.setBerryCounter(1);
        if(Globals.getBerryCounter() % 10 == 0){
            HealthPowerup apple = new HealthPowerup(pane);
        }
        if (Globals.getScore() % 150 == 0 || Globals.getScore() % 150 == 5){ //belenyúltam, elvileg így jó
            new PoisonEnemy(pane);
        }
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(4);
        destroy();
        //For testTD only, because later we'll need "bogyó"
        Globals.setScore(Globals.getScore() + 10);
        BerryPowerup berry = new BerryPowerup(pane);
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }


}
