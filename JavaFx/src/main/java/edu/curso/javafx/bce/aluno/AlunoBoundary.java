package edu.curso.javafx.bce.aluno;

import edu.curso.javafx.bce.tradicional.PetControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlunoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtRa = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtNascimento = new TextField();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private AlunoControl control = new AlunoControl(); //Composição

    private TableView<Aluno> table = new TableView<>();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private void criarTabela() {
        TableColumn<Aluno, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<>("id"));

        TableColumn<Aluno, Long> col2 = new TableColumn<>("Ra");
        col2.setCellValueFactory( new PropertyValueFactory<>("ra"));

        TableColumn<Aluno, String> col3 = new TableColumn<>("Nome");
        col3.setCellValueFactory( new PropertyValueFactory<>("nome"));

        TableColumn<Aluno, String> col4 = new TableColumn<>("Nascimento");
        col4.setCellValueFactory( (alunoProp) -> {
            LocalDate n = alunoProp.getValue().getNascimento();
            String strData = n.format(this.dtf);
            return new ReadOnlyStringWrapper(strData);
        } );


        table.getColumns().addAll(col1, col2, col3, col4);

        table.setItems(control.getLista());

        table
                .getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, antigo, novo) -> {
                            if (novo != null) {
                                control.setEntity(novo);
                            }
                        }
                );
    }

    @Override
    public void start(Stage stage) {
        BorderPane panelPrincipal = new BorderPane();
        GridPane panCampos = new GridPane();

        Bindings.bindBidirectional( txtId.textProperty(), control.id, new NumberStringConverter());
        Bindings.bindBidirectional( txtRa.textProperty(), control.ra, new NumberStringConverter());
        Bindings.bindBidirectional( txtNome.textProperty(), control.nome);
        Bindings.bindBidirectional( txtNascimento.textProperty(), control.nascimento, new LocalDateStringConverter());

        panCampos.add(new Label("Id"), 0, 0);
        panCampos.add(txtId, 1, 0);

        panCampos.add(new Label("Nome"), 0, 1);
        panCampos.add(txtNome, 1, 1);

        panCampos.add(new Label("Ra"), 0, 2);
        panCampos.add(txtRa, 1, 2);

        panCampos.add(new Label("Nascimento"), 0, 3);
        panCampos.add(txtNascimento, 1, 3);

        panCampos.add(btnAdicionar, 0, 4);
        panCampos.add(btnPesquisar, 1, 4);


        btnAdicionar.setOnAction( e -> {
            control.adicionar();
        });

        btnPesquisar.setOnAction( e -> {
            control.pesquisar();
//            if (p == null) {
//                Alert a = new Alert(Alert.AlertType.INFORMATION,
//                        "Pet não encontrado");
//                a.showAndWait();
//            } else {
//                entityToBoundary(p);
//            }
        });
        panelPrincipal.setTop(panCampos);
        panelPrincipal.setCenter(table);
        this.criarTabela();
        Scene scn = new Scene(panelPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Alunos");
        stage.show();
    }



    public static void main(String[] args) {
        Application.launch(edu.curso.javafx.bce.aluno.AlunoBoundary.class, args);
    }
}

