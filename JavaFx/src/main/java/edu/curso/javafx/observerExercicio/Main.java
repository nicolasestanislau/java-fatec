package edu.curso.javafx.observerExercicio;

public class Main {

    public static void main(String[] args) {
        Revista istoe = new SuperInterassante("IstoÉ");

        Leitor joao = new Leitor("João");

        istoe.adicionar(joao);

        istoe.publicarArtigo("Fatec ZL faz parceria com o MIT para desenvolvimento de novas tecnologias");
    }
}
