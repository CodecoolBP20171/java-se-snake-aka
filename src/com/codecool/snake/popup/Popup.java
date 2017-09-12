package com.codecool.snake.popup;

import com.codecool.snake.Globals;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

abstract public class Popup extends Application{

    public static void display(){

        Globals.popUp = new Stage();

        Globals.popUp.initModality(Modality.APPLICATION_MODAL);
        Globals.popUp.setTitle("Game over");

        Label label = new Label();

        Text score = new Text("Your score: "+Globals.score);

        Button restart = new Button("Restart");
        Button exit = new Button("Exit");

        restart.setOnAction(e -> Globals.game.restart());
        exit.setOnAction(e -> System.exit(0));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, score,restart, exit);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 300, 300);
        Globals.popUp.setScene(scene1);

        Globals.popUp.show();
    }

}
