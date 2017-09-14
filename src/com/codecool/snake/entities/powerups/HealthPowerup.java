package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;


public class HealthPowerup extends AbstractPowerup implements Animatable{

    long spawnTime;
    long aliveTime;
    private static final int heal = 20;

    public HealthPowerup(Pane pane){
        super(pane);
        setImage(Globals.apple);
        spawnTime = System.currentTimeMillis();
    }
    @Override
    public void apply(SnakeHead snakeHead){
        if (Globals.getHealth() == Globals.maxHealth){
            Globals.setScore(Globals.getScore() + 5);
        }
        if(Globals.getHealth() <= Globals.maxHealth-heal){
            Globals.setHealth(heal);

        } else {
            Globals.restartHealth();
        }
        destroy();
    }
    @Override
    public String getMessage(){
        return "Got health";
    }

    public void step(){
        aliveTime = System.currentTimeMillis() - spawnTime;
        if (aliveTime > Globals.defaultWaitTime){
            destroy();
        }
    }
}
