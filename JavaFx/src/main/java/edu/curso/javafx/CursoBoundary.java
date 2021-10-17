package edu.curso.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CursoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtCodCurso = new TextField();
    private TextField txtNomeCoordenador = new TextField();
    private TextField txtQtdCurso = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private List<Curso> lista = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        GridPane panelPrincipal = new GridPane();

        panelPrincipal.add(new Label("Id"), 0, 0);
        panelPrincipal.add(txtId, 1, 0);

        panelPrincipal.add(new Label("Nome"), 0, 1);
        panelPrincipal.add(txtNome, 1, 1);

        panelPrincipal.add(new Label("Codigo de curso"), 0, 2);
        panelPrincipal.add(txtCodCurso, 1, 2);

        panelPrincipal.add(new Label("Coordenador"), 0, 3);
        panelPrincipal.add(txtNomeCoordenador, 1, 3);

        panelPrincipal.add(new Label("Qtd de Alunos"), 0, 4);
        panelPrincipal.add(txtQtdCurso, 1, 4);

        panelPrincipal.add(btnAdicionar, 0, 5);
        panelPrincipal.add(btnPesquisar, 1, 5);

        btnAdicionar.setOnAction( e -> {
            Curso c = this.boundarytoEntity();
            lista.add(c);
            System.out.println(lista);
        });

        btnPesquisar.setOnAction( e -> {
            boolean encontrado = false;
            for(Curso c : lista) {
                if (c.getNome().contains(txtNome.getText())) {
                    this.entityToBoundary(c);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                Alert a = new Alert(Alert.AlertType.INFORMATION,
                        "Curso não encontrado");
                a.showAndWait();
            }
        });

        Scene scn = new Scene(panelPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Cursos");
        stage.show();
    }

    public Curso boundarytoEntity() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Curso c = new Curso();
        try {
            c.setId( Long.parseLong( txtId.getText() ) );
            c.setNome( txtNome.getText() );
            c.setCodCurso( Long.parseLong( txtCodCurso.getText() ) );
            c.setNomeCoordenador(txtNomeCoordenador.getText() );
            c.setQtdAlunos( Long.parseLong( txtQtdCurso.getText() ) );
        } catch (Exception e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return c;
    }

    public void entityToBoundary(Curso c) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (c != null) {
            txtId.setText(String.valueOf(c.getId()));
            txtNome.setText(c.getNome());
            txtCodCurso.setText(String.valueOf(c.getCodCurso()));
            txtNomeCoordenador.setText(c.getNomeCoordenador());
            txtQtdCurso.setText(String.valueOf(c.getQtdAlunos()));
        }
    }

    public static void main(String[] args) {
        Application.launch(CursoBoundary.class, args);
    }
}
