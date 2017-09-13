package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.enemies.FollowingEnemy;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    // This gets called every 1/60 seconds
    @Override
    public void handle(long now) {
        System.out.println(FollowingEnemy.enemyCounter);
        System.out.println(FollowingEnemy);
        if (FollowingEnemy.enemyCounter < 1 && Globals.getHealth() <= 80) {
            System.out.println(FollowingEnemy.enemyCounter);
            Globals.game.createFollowingEnemy();
        }

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
