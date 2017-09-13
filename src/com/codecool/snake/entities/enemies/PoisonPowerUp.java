package com.codecool.snake.entities.enemies;

import com.codecool.snake.Game;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class PoisonPowerUp extends SimpleEnemy {

    public PoisonPowerUp(Pane pane){
        super(pane);
        setImage(Globals.enemyPoison);
    }

    @Override
    public void apply(SnakeHead snakeHead){
        Globals.setHealth(-5);
        Game.snakeHead.setSpeed(Game.snakeHead.getSpeed()/2);
        destroy();
    }

    @Override
    public String getMessage(){
        return "You got poisoned!";
    }
}
