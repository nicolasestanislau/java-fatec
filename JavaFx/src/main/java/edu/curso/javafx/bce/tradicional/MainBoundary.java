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

public class MainBoundary extends Application implements CommandExecution {

    private PetBoundary petBoundary = new PetBoundary();
    private CreditoBoundary creditoBoundary = new CreditoBoundary();

    private BorderPane paneMain = new BorderPane();

    public MainBoundary() {
        creditoBoundary.addExecution(this);
        petBoundary.addExecution(this);
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
            execute("SAIR");
        });

        itemPets.setOnAction((e) -> {
            execute("BOUNDARY-PET");
        });
        itemCreditos.setOnAction((e) -> {
            execute("BOUNDARY-CREDITOS");
        });

        menuArquivo.getItems().addAll(itemSair);
        menuCadastro.getItems().addAll(itemPets);
        menuAjuda.getItems().addAll(itemCreditos);

        menuMain.getMenus().addAll(menuArquivo, menuCadastro, menuAjuda);

        paneMain.setTop(menuMain);

        stage.setScene(scn);
        stage.setTitle("Gestão de Pets");
        stage.show();
    }

//    @Override
//    public void handle(ActionEvent event) {
//        EventTarget target = event.getTarget();
//        if (target instanceof MenuItem) {
//            MenuItem menu = (MenuItem) target;
//            String texto = menu.getText();
//            StrategyBoundary tela = telas.get(texto);
//            paneMain.setCenter(tela.render());
//        }
//    }

    @Override
    public void execute(String command) {
        if("BOUNDARY-PET".equals(command)) {
            paneMain.setCenter(petBoundary.render());
        } else if("BOUNDARY-CREDITOS".equals(command)) {
            paneMain.setCenter(creditoBoundary.render());
        } else if("SAIR".equals(command)) {
            Platform.exit();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Application.launch(MainBoundary.class, args);
    }


}
