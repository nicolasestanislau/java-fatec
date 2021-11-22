package edu.curso.javafx.bce.curso;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CursoControl {
    LongProperty id = new SimpleLongProperty(0);
    LongProperty codCurso = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    StringProperty coordenador = new SimpleStringProperty("");
    LongProperty qntAlunos = new SimpleLongProperty(0);

    private ObservableList<Curso> listaView = FXCollections.observableArrayList();
    private CursoDAO cursoDAO = new CursoDAOImpl();

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

    public void salvar() {
        Curso c = getEntity();
        if(c.getId() == 0) {
            cursoDAO.adicionar(c);
            setEntity(new Curso());
        } else {
            cursoDAO.atualizar(id.get(), c);
        }
        atualizarListaView();
    }

    public void pesquisar() {
        listaView.clear();
        List<Curso> encontrados = cursoDAO.pesquisarPorNome(nome.get());
        listaView.addAll(encontrados);
    }

    public void novoCurso() {
        Curso c = new Curso();
        c.setId(0);
        setEntity(c);
    }

    public void remover(long id) {
        cursoDAO.remover(id);
        atualizarListaView();
    }

    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(cursoDAO.pesquisarPorNome(""));
    }
    public ObservableList<Curso>  getListaView() {
        return listaView;
    }

}
