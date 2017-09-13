package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;


public class HealthPowerup extends SimplePowerup implements Animatable{

    long spawnTime;
    long aliveTime;

    public HealthPowerup(Pane pane){
        super(pane);
        setImage(Globals.apple);
        spawnTime = System.currentTimeMillis();
    }
    @Override
    public void apply(SnakeHead snakeHead){
        if(Globals.getHealth() < 100){
            Globals.setHealth(20);
        } else {
            Globals.setScore(Globals.getScore() + 5);
        }
        System.out.println(Globals.getScore());

        destroy();
    }
    @Override
    public String getMessage(){
        return "Got health";
    }

    public void step(){
        aliveTime = System.currentTimeMillis() - spawnTime;
        if (aliveTime > 10000){
            destroy();
        }
    }
}
