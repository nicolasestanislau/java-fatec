package edu.curso.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tela extends Application {

    @Override
    public void start(Stage stage) {
        Pane panel = new Pane();
        Scene cena = new Scene(panel, 600, 400);

        Label hello = new Label("Hello world Java Fx");
        Button btnOK = new Button("Ok");
        hello.relocate(200, 200);
//        panel.getChildren().add(hello);
//        panel.getChildren().add(btnOK);
        panel.getChildren().addAll(hello, btnOK);
        stage.setScene(cena);
        stage.setTitle("Minha primeira application");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Tela.class, args);
    }



}
