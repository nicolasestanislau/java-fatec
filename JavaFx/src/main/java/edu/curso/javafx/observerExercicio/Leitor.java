package edu.curso.javafx.observerExercicio;

import java.util.ArrayList;
import java.util.List;

public class Leitor implements Observer{

    private String nome;

    public Leitor(String n){
        this.nome = n;
    }
    @Override
    public void update(String artigo) {
        System.out.println("O leitor " + this.nome + " está lendo o artigo " + artigo);
    }
}
