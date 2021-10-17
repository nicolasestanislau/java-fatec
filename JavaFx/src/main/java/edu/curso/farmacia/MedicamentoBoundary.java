
package edu.curso.farmacia;

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

public class MedicamentoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtPreco = new TextField();
    private TextField txtVencimento = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private List<Medicamento> lista = new ArrayList<>();
    @Override
    public void start(Stage stage) {
        GridPane panelPrincipal = new GridPane();

        panelPrincipal.add(new Label("Id"), 0, 0);
        panelPrincipal.add(txtId, 1, 0);

        panelPrincipal.add(new Label("Nome"), 0, 1);
        panelPrincipal.add(txtNome, 1, 1);

        panelPrincipal.add(new Label("Preço"), 0, 2);
        panelPrincipal.add(txtPreco, 1, 2);

        panelPrincipal.add(new Label("Data de Vencimento"), 0, 3);
        panelPrincipal.add(txtVencimento, 1, 3);

        panelPrincipal.add(btnAdicionar, 0, 4);
        panelPrincipal.add(btnPesquisar, 1, 4);

        btnAdicionar.setOnAction( e -> {
            Medicamento m = this.boundarytoEntity();
            lista.add(m);
            System.out.println(lista);
        });

        btnPesquisar.setOnAction( e -> {
            boolean encontrado = false;
            for(Medicamento m : lista) {
                if (m.getNome().contains(txtNome.getText())) {
                    this.entityToBoundary(m);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                Alert a = new Alert(Alert.AlertType.INFORMATION,
                        "Medicamento não encontrado");
                a.showAndWait();
            }
        });

        Scene scn = new Scene(panelPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Farmacia");
        stage.show();
    }

    public Medicamento boundarytoEntity() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Medicamento m = new Medicamento();
        try {
            m.setId( Long.parseLong( txtId.getText() ) );
            m.setNome( txtNome.getText() );
            m.setPreco( Double.parseDouble(txtPreco.getText()) );
            LocalDate dt = LocalDate.parse(txtVencimento.getText(), dtf);
            m.setVencimento( dt );
        } catch (Exception e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return m;
    }

    public void entityToBoundary(Medicamento m) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (m != null) {
            txtId.setText( String.valueOf(m.getId()) );
            txtNome.setText( m.getNome() );
            txtPreco.setText( String.valueOf(m.getPreco()) );
            String strVencimento = dtf.format(m.getVencimento());
            txtVencimento.setText( strVencimento );
        }
    }
    public static void main(String[] args) {
        Application.launch(MedicamentoBoundary.class, args);
    }
}

