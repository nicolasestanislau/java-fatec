package edu.curso.javafx.observerExercicio;

import java.util.ArrayList;
import java.util.List;

public class SuperInterassante implements Revista {

    private String nome;
    private List<Observer> observes = new ArrayList<>();

    public SuperInterassante(String n){
        this.nome = n;
    }

    @Override
    public void adicionar(Observer o) {
        observes.add(o);
    }

    @Override
    public void remover(Observer o) {
        observes.remove(o);
    }

    @Override
    public void publicarArtigo(String artigo) {
        System.out.println("Revista " + this.nome + " publica " + artigo);
        for(Observer o : observes){
            o.update(artigo);
        }
    }
}
