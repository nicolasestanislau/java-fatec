package edu.curso.javafx.bce.tradicional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class MainBoundary extends Application implements EventHandler<ActionEvent> {

    private Map<String, StrategyBoundary> telas = new HashMap<>();
    private BorderPane paneMain = new BorderPane();

    public MainBoundary() {
        telas.put("Pets", new PetBoundary());
        telas.put("Creditos", new CreditoBoundary());
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scn = new Scene(paneMain, 1024, 768);

        MenuBar menuMain = new MenuBar();

        Menu menuArquivo = new Menu("Arquivos");
        Menu menuCadastro = new Menu("Cadastro");
        Menu menuAjuda = new Menu("Ajuda");

        MenuItem itemSair = new MenuItem("Sair");
        MenuItem itemPets = new MenuItem("Pets");
        MenuItem itemCreditos = new MenuItem("Creditos");

        itemSair.setOnAction((e) -> {
            Platform.exit();
            System.exit(0);
        });

        itemPets.setOnAction(this);
        itemCreditos.setOnAction(this);

        menuArquivo.getItems().addAll(itemSair);
        menuCadastro.getItems().addAll(itemPets);
        menuAjuda.getItems().addAll(itemCreditos);

        menuMain.getMenus().addAll(menuArquivo, menuCadastro, menuAjuda);

        paneMain.setTop(menuMain);

        stage.setScene(scn);
        stage.setTitle("Gestão de Pets");
        stage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        EventTarget target = event.getTarget();
        if (target instanceof MenuItem) {
            MenuItem menu = (MenuItem) target;
            String texto = menu.getText();
            StrategyBoundary tela = telas.get(texto);
            paneMain.setCenter(tela.render());
        }
    }

    public static void main(String[] args) {
        Application.launch(MainBoundary.class, args);
    }
}
