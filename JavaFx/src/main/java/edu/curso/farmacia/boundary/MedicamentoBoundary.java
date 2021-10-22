
package edu.curso.farmacia.boundary;

import edu.curso.farmacia.control.MedicamentoControl;
import edu.curso.farmacia.entidade.Medicamento;
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

public class MedicamentoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtPreco = new TextField();
    private TextField txtVencimento = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private MedicamentoControl control = new MedicamentoControl();

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
            control.adicionar(m);
        });

        btnPesquisar.setOnAction( e -> {
            Medicamento m = control.pesquisar(txtNome.getText());
            if (m == null) {
                Alert a = new Alert(Alert.AlertType.INFORMATION,
                        "Medicamento não encontrado");
                a.showAndWait();
            } else {
                entityToBoundary(m);
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

