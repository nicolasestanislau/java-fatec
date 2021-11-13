package edu.curso.javafx.observerExercicio;

public interface Revista {
    void adicionar(Observer o);
    void remover(Observer o);
    void publicarArtigo(String artigo);
}
