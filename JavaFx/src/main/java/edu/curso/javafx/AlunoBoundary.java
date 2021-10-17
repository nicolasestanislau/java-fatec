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

public class AlunoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtRa = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtNascimento = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private List<Aluno> lista = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        GridPane panelPrincipal = new GridPane();

        panelPrincipal.add(new Label("Id"), 0, 0);
        panelPrincipal.add(txtId, 1, 0);

        panelPrincipal.add(new Label("Ra"), 0, 1);
        panelPrincipal.add(txtRa, 1, 1);

        panelPrincipal.add(new Label("Nome"), 0, 2);
        panelPrincipal.add(txtNome, 1, 2);

        panelPrincipal.add(new Label("Nascimento"), 0, 3);
        panelPrincipal.add(txtNascimento, 1, 3);

        panelPrincipal.add(btnAdicionar, 0, 4);
        panelPrincipal.add(btnPesquisar, 1, 4);

        btnAdicionar.setOnAction( e -> {
            Aluno a = this.boundarytoEntity();
            lista.add(a);
            System.out.println(lista);
        });

        btnPesquisar.setOnAction( e -> {
            boolean encontrado = false;
            for(Aluno a : lista) {
                if (a.getNome().contains(txtNome.getText())) {
                    this.entityToBoundary(a);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Aluno não encontrado");
                alert.showAndWait();
            }
        });

        Scene scn = new Scene(panelPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }

    public Aluno boundarytoEntity() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Aluno a = new Aluno();
        try {
            a.setId( Long.parseLong( txtId.getText() ) );
            a.setRa( Long.parseLong( txtRa.getText() ) );
            a.setNome( txtNome.getText() );
            LocalDate dt = LocalDate.parse(txtNascimento.getText(), dtf);
            a.setNascimento( dt );
        } catch (Exception e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return a;
    }

    public void entityToBoundary(Aluno a) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (a != null) {
            txtId.setText( String.valueOf(a.getId()) );
            txtRa.setText( String.valueOf(a.getRa()) );
            txtNome.setText( a.getNome() );
            String strNascimento = dtf.format(a.getNascimento());
            txtNascimento.setText( strNascimento );
        }
    }

    public static void main(String[] args) {
        Application.launch(AlunoBoundary.class, args);
    }
}
