package com.codecool.snake.entities.label;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HealthText extends GameEntity implements Animatable {
    private Label healthText;

    public HealthText(Pane pane) {
        super(pane);
        healthText = new Label();
        pane.getChildren().add(healthText);
    }

    public void step() {

        String health = "Health: " + String.valueOf(Globals.getHealth());
        healthText.setLayoutX(0);
        healthText.setLayoutY(0);
        healthText.setFont(Font.font("Verdana", 30));
        healthText.setTextFill(Color.web("#0076a3"));
        healthText.setText(health);
    }

}
