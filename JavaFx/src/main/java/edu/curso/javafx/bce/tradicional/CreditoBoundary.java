package edu.curso.javafx.bce.tradicional;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CreditoBoundary extends CommandProducer implements StrategyBoundary {

    @Override
    public Pane render() {

        VBox pane = new VBox();
        Button btnPets = new Button("Cadastro Pets");
        pane.getChildren().addAll(
                new Label("ricardo Satoshi"),
                new Label("Fatec Zona Leste"),
                new Label("Coordenador Luciano Oliveira"),
                btnPets
        );
        btnPets.setOnAction((e) -> {
            executeCommand("BOUNDARY-PET");

        });

        return pane;
    }
}
