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

class ManipuladorHandleLabel implements EventHandler<ActionEvent> {
    Label labelTeste;
    @Override
    public void handle(ActionEvent e) {
        if (e.getTarget() instanceof  Button) {
            Button btn = (Button) e.getTarget();
            if (btn.getText().equals("Ok")){
                labelTeste.setText("Botão Ok Apertado");
            }else if (btn.getText().equals("OutroButton")){
                labelTeste.setText("Outro Botao Apertado");
            }
        }
    }
}

public class ButtonPressLabel extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane panelPrincipal = new BorderPane();
        Scene scene = new Scene(panelPrincipal, 400, 300);

        Label hello = new Label("Texto");
        Button btn = new Button("Ok");

        Button btnOutro = new Button("OutroButton");
        panelPrincipal.setRight(btnOutro);

        BorderPane.setAlignment(hello, Pos.CENTER);
        BorderPane.setAlignment(btn, Pos.CENTER);

//        ====== Primeira forma de fazer, criando uma classe externa com o codigo para ser executado quando o botão for pressionado ======

//        ManipuladorHandleLabel handle = new ManipuladorHandleLabel();
//        handle.labelTeste = hello;
//        btn.addEventFilter(ActionEvent.ANY, handle);
//        btnOutro.addEventFilter(ActionEvent.ANY, handle);

//        ====== Segunda forma, fazendo uma classe anonima ======

//        EventHandler<ActionEvent> handle = new EventHandler<ActionEvent>(){
//            public void handle(ActionEvent e) {
//                hello.setText("Algum botão foi pressionado");
//            }
//        };

//        btn.addEventFilter(ActionEvent.ANY, handle);
//        btnOutro.addEventFilter(ActionEvent.ANY, handle);

        //====== Terceira forma, fazendo uma classe anonima sem variável de referencia ======

//        btn.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent e) {
//                hello.setText("Botão Ok foi apertado");
//            }
//        });
//
//        btnOutro.addEventFilter(ActionEvent.ANY, new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent e) {
//                hello.setText("Botão Outro foi apertado");
//            }
//        });

        // ====== Quarta Forma, uso do Lambda ======

//        btn.addEventHandler(ActionEvent.ANY, (e) -> {
//            hello.setText("Botão Ok foi apertado Lambda");
//        });
//
//        btnOutro.addEventHandler(ActionEvent.ANY, e -> {
//            hello.setText("Botão Outro foi apertado Lambda");
//        });

        // ====== Quinta Forma, uso do Lambda e do setOnAction ======

        btn.setOnAction( e -> {
            hello.setText("Botão Ok foi apertado usando setOnAction");
        });

        btnOutro.setOnAction( e -> {
            hello.setText("Botão Outro foi apertado usando setOnAction");
        });

        panelPrincipal.setBottom(btn);
        panelPrincipal.setTop(hello);

        stage.setScene(scene);
        stage.setTitle("Exercicio de Pressionamento de Botão label");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(ButtonPressLabel.class, args);
    }
}