package edu.curso.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//class Manipulador implements EventHandler<MouseEvent> {
//    public void handle(MouseEvent e) {
//        System.out.println("Botão Apertado");
//        System.out.println("Tipo ===> " + e.getEventType() + " x : " + e.getX() + " y : " + e.getY());
//    }
//}

class Manipulador implements EventHandler<ActionEvent> {
    public void handle(ActionEvent e) {
        System.out.println("O botão foi pressionado");
    }
}

public class PressionamentoBotao extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane panelPrincipal =new BorderPane();
        Scene scene = new Scene(panelPrincipal, 400, 300);
        Manipulador man = new Manipulador();
        Button btn = new Button("Aperte-me");
        btn.addEventFilter(ActionEvent.ANY, man);
        panelPrincipal.setCenter(btn);

        stage.setScene(scene);
        stage.setTitle("Teste de Pressionamento de Botão");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(PressionamentoBotao.class, args);
    }
}
