package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class BasicEnemy extends AbstractEnemy implements Animatable{

    private static final int damage = -20;

    public BasicEnemy(Pane pane){
        super(pane);
        setImage(Globals.simpleEnemy);
        addEnemy(this);
    }

    @Override
    public void apply(SnakeHead player) {
        Globals.setHealth(damage);
        destroy();
        getEnemies().remove(this);
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
        setRotate(direction);
        setX(getX() + getHeading().getX());
        setY(getY() + getHeading().getY());
    }
}
