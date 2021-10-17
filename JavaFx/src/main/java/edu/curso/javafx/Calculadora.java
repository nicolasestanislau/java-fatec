package edu.curso.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Calculadora extends Application {

    @Override
    public void start(Stage stage){
        BorderPane panelPrincipal = new BorderPane();
        GridPane panelButton = new GridPane();
        FlowPane panelDisplay = new FlowPane();

        panelPrincipal.setTop(panelDisplay);
        panelPrincipal.setCenter(panelButton);
        panelButton.setVgap(5);
        panelButton.setHgap(5);

        BorderPane.setMargin(panelButton, new Insets(20));
        BorderPane.setMargin(panelDisplay, new Insets(20));

        panelDisplay.setHgap(5);

        ColumnConstraints colCons = new ColumnConstraints();
        colCons.setPercentWidth(25);
        panelButton.getColumnConstraints().addAll(colCons, colCons, colCons, colCons);
        RowConstraints rowCons = new RowConstraints();
        rowCons.setPercentHeight(25);
        panelButton.getRowConstraints().addAll(rowCons, rowCons, rowCons, rowCons);
        TextField txtDisplay = new TextField("0");
        txtDisplay.setStyle("-fx-background-color: cyan");
        txtDisplay.setPrefColumnCount(14);
        txtDisplay.setPrefHeight(40);
        panelDisplay.getChildren().add(txtDisplay);
        panelDisplay.getChildren().add(new Button("CE"));

        String[] botoes = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", ".", "0", "=", "/"};
        int col = 0;
        int lin = 0;
        for (int i = 0; i < botoes.length; i++) {
            Button btn = new Button(botoes[i]);
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            panelButton.add(btn, col, lin);
            col++;
            if (col >= 4) {
                lin++;
                col =0;
            }
        }

        Scene scene = new Scene(panelPrincipal, 300, 600);

        stage.setScene(scene);
        stage.setTitle("Calculadora");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(Calculadora.class, args);
    }
}
