package edu.curso.javafx.observerExercicio;

public interface Subject {
    void notificar();
    void registrar(Observer o);
}
