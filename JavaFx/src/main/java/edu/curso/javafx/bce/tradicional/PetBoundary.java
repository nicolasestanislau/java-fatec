package edu.curso.javafx.bce.tradicional;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetBoundary extends Application {

    private TextField txtId = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtRaca = new TextField();
    private TextField txtPeso = new TextField();
    private DatePicker dtNascimento = new DatePicker();

    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");

    private PetControl control = new PetControl(); //Composição

    private TableView<Pet> table = new TableView<>();

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private void criarTabela() {
        TableColumn<Pet, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<>("id"));

        TableColumn<Pet, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory( new PropertyValueFactory<>("nome"));

        TableColumn< Pet, String> col3 = new TableColumn<>("Raça");
        col3.setCellValueFactory( new PropertyValueFactory<>("raca"));

        TableColumn< Pet, Double> col4 = new TableColumn<>("Peso");
        col4.setCellValueFactory( new PropertyValueFactory<>("peso"));

        TableColumn<Pet, String> col5 = new TableColumn<>("Nascimento");
        col5.setCellValueFactory( (petProp) -> {
            LocalDate n = petProp.getValue().getNascimento();
            String strData = n.format(this.dtf);
            return new ReadOnlyStringWrapper(strData);
        } );

//        TableColumn< Pet, String> col6 = new TableColumn<>("Ações");
//        col6.setCellValueFactory( new PropertyValueFactory<>("DUMMY"));
//        col6.setCellValueFactory( (tbCol) ->
//                new TableCell<Pet, String>() {
//            final Button btn = new Button("Remover");
//
//            public void updateItem(String item, boolean empty) {
//                if (empty) {
//                    setGraphic(null);
//                    setText(null);
//                } else {
//                    btn.setOnAction((e) -> {
//                        Pet p = getTableView().getItems().get(getIndex());
//                        control.remover(p.getId());
//                    });
//                    setGraphic(btn);
//                    setText(null);
//                }
//            }
//                }
//        );

        table.getColumns().addAll(col1, col2, col3, col4, col5);

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
        txtId.setDisable(true);
        Bindings.bindBidirectional( txtId.textProperty(), control.id, new NumberStringConverter());
        Bindings.bindBidirectional( txtNome.textProperty(), control.nome);
        Bindings.bindBidirectional( txtRaca.textProperty(), control.raca);
        Bindings.bindBidirectional( txtPeso.textProperty(), control.peso, new NumberStringConverter());
        Bindings.bindBidirectional( dtNascimento.valueProperty(), control.nascimento);

        panCampos.add(new Label("Id"), 0, 0);
        panCampos.add(txtId, 1, 0);

        panCampos.add(new Label("Nome"), 0, 1);
        panCampos.add(txtNome, 1, 1);

        panCampos.add(new Label("Raça"), 0, 2);
        panCampos.add(txtRaca, 1, 2);

        panCampos.add(new Label("Peso"), 0, 3);
        panCampos.add(txtPeso, 1, 3);

        panCampos.add(new Label("Nascimento"), 0, 4);
        panCampos.add(dtNascimento, 1, 4);

        //panCampos.add(btnNovoPet, 0, 5);
        panCampos.add(btnAdicionar, 0, 5);
        panCampos.add(btnPesquisar, 1, 5);


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
        stage.setTitle("Gestão de Pets");
        stage.show();
    }



    public static void main(String[] args) {
        Application.launch(PetBoundary.class, args);
    }
}
