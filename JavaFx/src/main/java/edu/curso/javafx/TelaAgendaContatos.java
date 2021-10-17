package edu.curso.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TelaAgendaContatos extends Application {

    @Override
    public void start(Stage stage) {
        Pane painel = new Pane();
        Scene scene = new Scene(painel, 600, 300);

        Label labelId = new Label("Id: ");
        labelId.relocate(20.0, 30.0);
        Label labelNome = new Label("Nome: ");
        labelNome.relocate(20.0, 80.0);
        Label labelTel = new Label("Telefone: ");
        labelTel.relocate(20.0, 130.0);

        TextField txtId = new TextField();
        txtId.relocate(150.0, 30.0);
        txtId.setPrefWidth(350.0);
        TextField txtNome = new TextField();
        txtNome.relocate(150.0, 80.0);
        txtNome.setPrefWidth(350.0);
        TextField txtTel = new TextField();
        txtTel.relocate(150.0, 130.0);
        txtTel.setPrefWidth(350.0);

        Button btnSave = new Button("salvar");
        btnSave.relocate(20.0, 180.0);
        Button btnSearch = new Button("pesquisar");
        btnSearch.relocate(80.0, 180.0);

        painel.getChildren().addAll(labelId, txtId, labelNome, txtNome, labelTel, txtTel, btnSave, btnSearch);


        stage.setScene(scene);
        stage.setTitle("Agenda de Contatos");
        stage.show();

    }
}
