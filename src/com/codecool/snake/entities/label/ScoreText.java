package com.codecool.snake.entities.label;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScoreText extends GameEntity {

    public ScoreText(Pane pane) {
        super(pane);
        String score = "Score: " + String.valueOf(Globals.getScore());
        Text scoreText = new Text(5, 30, score);
        scoreText.setFont(Font.font("Verdana", 30));
        pane.getChildren().add(scoreText);
    }
}
