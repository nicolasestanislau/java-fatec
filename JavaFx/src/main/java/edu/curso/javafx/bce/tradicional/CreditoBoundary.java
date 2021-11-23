package edu.curso.javafx.bce.tradicional;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CreditoBoundary implements StrategyBoundary {

    @Override
    public Pane render() {
        VBox pane = new VBox();

        pane.getChildren().addAll(
                new Label("ricardo Satoshi"),
                new Label("Fatec Zona Leste"),
                new Label("Coordenador Luciano Oliveira")
        );

        return pane;
    }
}
