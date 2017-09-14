package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class BasicEnemy extends SimpleEnemy implements Animatable{

    public BasicEnemy(Pane pane){
        super(pane);
        setImage(Globals.simpleEnemy);
    }

    @Override
    public void apply(SnakeHead player) {
        Globals.setHealth(-20);
        destroy();
        getEnemies().remove(this);
        if (getEnemies().size() <=2){
           new BasicEnemy(pane);
        }
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            if (getX() < 0 || getX() > (Globals.WINDOW_WIDTH-Globals.simpleEnemy.getWidth())) {
                this.direction = 360 - getDirection();
                setHeading(Utils.directionToVector(direction, speed));
            } else if (getY() < 0 || getY() > (Globals.WINDOW_HEIGHT-Globals.simpleEnemy.getHeight())) {
                if (getDirection() >= 180) {
                    this.direction = 360 - getDirection() + 180;
                    setHeading(Utils.directionToVector(direction, speed));
                } else {
                    this.direction = 180 - getDirection();
                    setHeading(Utils.directionToVector(direction, speed));
                }
            } else {}
        }
        setX(getX() + getHeading().getX());
        setY(getY() + getHeading().getY());
    }
}
