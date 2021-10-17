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
import java.util.List;
import java.util.ArrayList;

public class PetBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtRaca = new TextField();
    private TextField txtPeso = new TextField();
    private TextField txtNascimento = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private List<Pet> lista = new ArrayList<>();
    @Override
    public void start(Stage stage) {
        GridPane panelPrincipal = new GridPane();

        panelPrincipal.add(new Label("Id"), 0, 0);
        panelPrincipal.add(txtId, 1, 0);

        panelPrincipal.add(new Label("Nome"), 0, 1);
        panelPrincipal.add(txtNome, 1, 1);

        panelPrincipal.add(new Label("Raça"), 0, 2);
        panelPrincipal.add(txtRaca, 1, 2);

        panelPrincipal.add(new Label("Peso"), 0, 3);
        panelPrincipal.add(txtPeso, 1, 3);

        panelPrincipal.add(new Label("Nascimento"), 0, 4);
        panelPrincipal.add(txtNascimento, 1, 4);

        panelPrincipal.add(btnAdicionar, 0, 5);
        panelPrincipal.add(btnPesquisar, 1, 5);

        btnAdicionar.setOnAction( e -> {
            Pet p = this.boundarytoEntity();
            lista.add(p);
            System.out.println(lista);
        });

        btnPesquisar.setOnAction( e -> {
            boolean encontrado = false;
            for(Pet p : lista) {
                if (p.getNome().contains(txtNome.getText())) {
                    this.entityToBoundary(p);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                Alert a = new Alert(Alert.AlertType.INFORMATION,
                        "Pet não encontrado");
                a.showAndWait();
            }
        });

        Scene scn = new Scene(panelPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Pets");
        stage.show();
    }

    public Pet boundarytoEntity() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Pet p = new Pet();
        try {
            p.setId( Long.parseLong( txtId.getText() ) );
            p.setNome( txtNome.getText() );
            p.setRaca( txtRaca.getText() );
            p.setPeso( Double.parseDouble(txtPeso.getText()) );
            LocalDate dt = LocalDate.parse(txtNascimento.getText(), dtf);
            p.setNascimento( dt );
        } catch (Exception e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return p;
    }

    public void entityToBoundary(Pet p) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (p != null) {
            txtId.setText( String.valueOf(p.getId()) );
            txtNome.setText( p.getNome() );
            txtRaca.setText( p.getRaca() );
            txtPeso.setText( String.valueOf(p.getPeso()) );
            String strNascimento = dtf.format(p.getNascimento());
            txtNascimento.setText( strNascimento );
        }

    }

    public static void main(String[] args) {
        Application.launch(PetBoundary.class, args);
    }
}
