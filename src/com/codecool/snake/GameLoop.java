package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.enemies.AbstractEnemy;
import com.codecool.snake.entities.enemies.BasicEnemy;
import com.codecool.snake.entities.enemies.FollowingEnemy;
import com.codecool.snake.entities.enemies.PoisonEnemy;
import com.codecool.snake.entities.powerups.HealthPowerup;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
        if (FollowingEnemy.enemyCounter < 1 && Globals.getHealth() >= 50) Globals.game.createFollowingEnemy();

        if(Globals.getBerryCounter() % Globals.nextHealthPowerUpTurn == 0) Globals.game.createHealthPowerUp();

        if (!Globals.isPoison) Globals.game.createPoisonEnemy();

        if (AbstractEnemy.getEnemies().size() < 2) Globals.game.createBasicEnemy();

        for (GameEntity gameObject : Globals.gameObjects) {
            if (gameObject instanceof Animatable) {
                Animatable animObject = (Animatable)gameObject;
                animObject.step();
            }
        }
        Globals.gameObjects.addAll(Globals.newGameObjects);
        Globals.newGameObjects.clear();

        Globals.gameObjects.removeAll(Globals.oldGameObjects);
        Globals.oldGameObjects.clear();

    }
}
