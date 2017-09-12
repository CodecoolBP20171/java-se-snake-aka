package com.codecool.snake.entities.label;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HealthText extends GameEntity implements Animatable {
    private Text healthText;

    public HealthText(Pane pane) {
        super(pane);
        healthText = new Text();
        pane.getChildren().add(healthText);
    }

    public void step() {

        String health = "Health: " + String.valueOf(Globals.getHealth());
        healthText.setX(5);
        healthText.setY(30);
        healthText.setFont(Font.font("Verdana", 30));
        healthText.setText(health);
    }

}
