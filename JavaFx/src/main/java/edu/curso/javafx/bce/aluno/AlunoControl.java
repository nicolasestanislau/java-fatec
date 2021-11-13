package edu.curso.javafx.bce.aluno;

import edu.curso.javafx.bce.tradicional.Pet;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class AlunoControl {

    LongProperty id = new SimpleLongProperty(0);
    LongProperty ra = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    ObjectProperty nascimento = new SimpleObjectProperty(LocalDate.now());

    private ObservableList<Aluno> lista = FXCollections.observableArrayList();

    public Aluno getEntity() {
        Aluno a = new Aluno();
        a.setId( id.get());
        a.setRa( ra.get());
        a.setNome(nome.get());
        a.setNascimento((LocalDate) nascimento.get());
        return a;
    }

    public void setEntity(Aluno a) {
        id.set(a.getId());
        ra.set(a.getRa());
        nome.set(a.getNome());
        nascimento.set(a.getNascimento());
    }

    public void adicionar() {
        Aluno a = getEntity();
        lista.add(a);
        //System.out.println(lista);
    }

    public void pesquisar() {
        for (Aluno a: lista) {
            if (a.getNome().contains(nome.get())) {
                setEntity(a);
                break;
            }
        }
    }

    public ObservableList<Aluno>  getLista() {
        return lista;
    }
}

