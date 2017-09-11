package com.codecool.snake.entities.label;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;

public class ScoreText extends GameEntity {

    public ScoreText(Pane pane) {
        super(pane);
        setX(50);
        setY(50);
        pane.getChildren().add(this);
        System.out.println(Globals.getScore());
    }





}
