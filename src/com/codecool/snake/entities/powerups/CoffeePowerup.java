package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import javafx.scene.layout.Pane;

public class CoffeePowerup extends SimplePowerup {
    public CoffeePowerup(Pane pane){
        super(pane);
        setImage(Globals.powerupCoffee);

        if(Globals.getBerryCounter() % 10 == 0){
            HealthPowerup apple = new HealthPowerup(pane);
        }




}
