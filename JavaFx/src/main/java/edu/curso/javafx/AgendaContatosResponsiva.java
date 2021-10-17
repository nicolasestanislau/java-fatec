package edu.curso.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AgendaContatosResponsiva extends Application {

    @Override
    public void start(Stage stage) {
        FlowPane painel = new FlowPane();
        painel.setVgap(20);
        painel.setHgap(20);
        Scene scene = new Scene(painel, 600, 300);

        Label labelId = new Label("Id: ");
        Label labelNome = new Label("Nome: ");
        Label labelTel = new Label("Telefone: ");

        TextField txtId = new TextField();
        txtId.setPrefWidth(350.0);
        TextField txtNome = new TextField();
        txtNome.setPrefWidth(350.0);
        TextField txtTel = new TextField();
        txtTel.setPrefWidth(350.0);

        Button btnSave = new Button("salvar");
        Button btnSearch = new Button("pesquisar");

        painel.getChildren().addAll(labelId, txtId, labelNome, txtNome, labelTel, txtTel, btnSave, btnSearch);


        stage.setScene(scene);
        stage.setTitle("Agenda de Contatos");
        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(AgendaContatosResponsiva.class, args);
    }
}
