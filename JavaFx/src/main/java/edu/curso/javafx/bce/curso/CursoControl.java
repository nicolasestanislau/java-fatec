package edu.curso.javafx.bce.curso;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CursoControl {
    LongProperty id = new SimpleLongProperty(0);
    LongProperty codCurso = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    StringProperty coordenador = new SimpleStringProperty("");
    LongProperty qntAlunos = new SimpleLongProperty(0);

    private List<Curso> lista = new ArrayList<>();
    private ObservableList<Curso> listaView = FXCollections.observableArrayList();

    public Curso getEntity() {
        Curso c = new Curso();
        c.setId(id.get());
        c.setCodCurso(codCurso.get());
        c.setNome(nome.get());
        c.setCoordenador(coordenador.get());
        c.setQntAlunos(qntAlunos.get());
        return c;
    }

    public void setEntity(Curso c) {
        id.set(c.getId());
        codCurso.set(c.getCodCurso());
        nome.set(c.getNome());
        coordenador.set(c.getCoordenador());
        qntAlunos.set(c.getQntAlunos());
    }

    public void adicionar() {
        Curso c = getEntity();
        lista.add(c);
        atualizarListaView();
    }

    public void pesquisar() {
        listaView.clear();
        for (Curso c : lista) {
            if (c.getNome().contains(nome.get())) {
                listaView.add(c);
            }
        }
    }

    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(lista);
    }
    public ObservableList<Curso>  getListaView() {
        return listaView;
    }

}
