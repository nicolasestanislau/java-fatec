package edu.curso.javafx.observerExercicio;



import java.util.ArrayList;
import java.util.List;

public class Leitor implements Observer{

    private List<Revista> revistas = new ArrayList<>();

    @Override
    public void update(Revista r) {
        System.out.println("Lendo o artigo " + r);
//        for (Revista r : revistas ) {
//            r.artigo();
//        }
    }
}
