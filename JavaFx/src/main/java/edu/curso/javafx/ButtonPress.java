package edu.curso.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class ManipuladorHandle implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
        System.out.println("Hello World");
    }
}

public class ButtonPress extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane panelPrincipal =new BorderPane();
        Scene scene = new Scene(panelPrincipal, 400, 300);

        Label hello = new Label("Texto");

        ManipuladorHandle man = new ManipuladorHandle();
        Button btn = new Button("Ok");
        btn.addEventFilter(ActionEvent.ANY, man);
        BorderPane.setAlignment(hello, Pos.CENTER);
        panelPrincipal.setCenter(btn);
        panelPrincipal.setTop(hello);

        stage.setScene(scene);
        stage.setTitle("Exercicio de Pressionamento de Botão");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ButtonPress.class, args);
    }
}

