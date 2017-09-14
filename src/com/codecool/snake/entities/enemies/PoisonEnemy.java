package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.powerups.CoffeePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class PoisonEnemy extends AbstractEnemy {

    private static final int damage = -5;

    public PoisonEnemy(Pane pane){
        super(pane);
        setImage(Globals.poisonEnemy);
    }

    @Override
    public void apply(SnakeHead player) {
        Globals.setHealth(damage);
        SnakeHead.setSpeed(SnakeHead.getSpeed()/2);
        new CoffeePowerup(pane);
        destroy();
    }

    @Override
    public String getMessage() {
        return "POISOOOOOOON";
    }
}
