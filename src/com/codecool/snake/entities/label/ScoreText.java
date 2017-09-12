package com.codecool.snake.entities.label;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ScoreText extends GameEntity implements Animatable {
    private Text scoreText;

    public ScoreText(Pane pane) {
        super(pane);
        scoreText = new Text();
        pane.getChildren().add(scoreText);
    }

    public void step() {
        // For TEST only
        Globals.setScore(Globals.getScore() + 1);
        
        String score = "Score: " + String.valueOf(Globals.getScore());
        scoreText.setX(20);
        scoreText.setY(30);
        scoreText.setText(score);
    }

}
