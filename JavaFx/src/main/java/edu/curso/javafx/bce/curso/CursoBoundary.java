package edu.curso.javafx.bce.curso;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.util.Optional;

public class CursoBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtCodCurso = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtCoordenador = new TextField();
    private TextField txtQntAlunos = new TextField();

    private Button btnNovoCurso = new Button("Novo Curso");
    private Button btnSalvar = new Button("Salvar");
    private Button btnPesquisar = new Button("Pesquisar");

    private CursoControl control = new CursoControl(); //Composição

    private TableView<Curso> table = new TableView<>();

    private void criarTabela() {
        TableColumn<Curso, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<>("id"));

        TableColumn<Curso, Long> col2 = new TableColumn<>("Código do Curso");
        col2.setCellValueFactory( new PropertyValueFactory<>("codCurso"));

        TableColumn<Curso, String> col3 = new TableColumn<>("Nome");
        col3.setCellValueFactory( new PropertyValueFactory<>("nome"));

        TableColumn<Curso, String> col4 = new TableColumn<>("Nome do Coordenador");
        col4.setCellValueFactory( new PropertyValueFactory<>("coordenador"));

        TableColumn<Curso, Long> col5 = new TableColumn<>("Quantidade de Alunos");
        col5.setCellValueFactory( new PropertyValueFactory<>("qntAlunos"));

        TableColumn<Curso, String> col6 = new TableColumn<>("Açoes");
        col6.setCellValueFactory( new PropertyValueFactory<>("DUMMY") );
        col6.setCellFactory( (tbCol) ->
                new TableCell<Curso, String>(){
                    final Button btn = new Button("Remover");

                    public void updateItem(String item, boolean empty) {
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction( (e) -> {
                                Curso c = getTableView().getItems().get(getIndex());
                                Alert alert = new Alert(Alert.AlertType.WARNING, "Você confirma a remoção do Curso Id " +
                                        c.getId(), ButtonType.OK, ButtonType.CANCEL);
                                Optional<ButtonType> clicado = alert.showAndWait();
                                if (clicado.isPresent() && clicado.get().equals(ButtonType.OK)) {
                                    control.remover(c.getId());
                                }
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                }
        );


        table.getColumns().addAll(col1, col2, col3, col4, col5, col6);

        table.setItems(control.getListaView());

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
        txtId.setEditable(false);
        txtId.setDisable(true);
        Bindings.bindBidirectional( txtId.textProperty(), control.id, new NumberStringConverter());
        Bindings.bindBidirectional( txtCodCurso.textProperty(), control.codCurso, new NumberStringConverter());
        Bindings.bindBidirectional( txtNome.textProperty(), control.nome);
        Bindings.bindBidirectional( txtCoordenador.textProperty(), control.coordenador);
        Bindings.bindBidirectional( txtQntAlunos.textProperty(), control.qntAlunos, new NumberStringConverter());

        panCampos.add(new Label("Id"), 0, 0);
        panCampos.add(txtId, 1, 0);

        panCampos.add(btnNovoCurso, 2, 0);

        panCampos.add(new Label("Código do Curso"), 0, 1);
        panCampos.add(txtCodCurso, 1, 1);

        panCampos.add(new Label("Nome"), 0, 2);
        panCampos.add(txtNome, 1, 2);

        panCampos.add(new Label("Nome do Coordenador"), 0, 3);
        panCampos.add(txtCoordenador, 1, 3);

        panCampos.add(new Label("Quantidades de Alunos"), 0, 4);
        panCampos.add(txtQntAlunos, 1, 4);

        panCampos.add(btnSalvar, 0, 5);
        panCampos.add(btnPesquisar, 1, 5);

        btnSalvar.setOnAction( e -> {
            control.salvar();
        });

        btnPesquisar.setOnAction( e -> {
            control.pesquisar();
        });

        btnNovoCurso.setOnAction( e -> {
            control.novoCurso();
        });

        panelPrincipal.setTop(panCampos);
        panelPrincipal.setCenter(table);
        this.criarTabela();
        Scene scn = new Scene(panelPrincipal, 600, 400);

        stage.setScene(scn);
        stage.setTitle("Gestão de Cursos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(CursoBoundary.class, args);
    }
}
