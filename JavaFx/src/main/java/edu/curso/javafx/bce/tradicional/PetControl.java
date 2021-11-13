package edu.curso.javafx.bce.tradicional;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PetControl {

    LongProperty id = new SimpleLongProperty(0);
    StringProperty nome = new SimpleStringProperty("");
    StringProperty raca = new SimpleStringProperty("");
    DoubleProperty peso = new SimpleDoubleProperty(0);
    ObjectProperty nascimento = new SimpleObjectProperty(LocalDate.now());

    private List<Pet> lista = new ArrayList<>();
    private ObservableList<Pet> listaView = FXCollections.observableArrayList();

    public Pet getEntity() {
        Pet p = new Pet();
        p.setId(id.get());
        p.setNome(nome.get());
        p.setRaca(raca.get());
        p.setPeso(peso.get());
        p.setNascimento((LocalDate) nascimento.get());
        return p;
    }

    public void setEntity(Pet p) {
        id.set(p.getId());
        nome.set(p.getNome());
        raca.set(p.getRaca());
        peso.set(p.getPeso());
        nascimento.set(p.getNascimento());
    }

    public void adicionar() {
        Pet p = getEntity();
        lista.add(p);
        atualizarListaView();
    }

    public void pesquisar() {
        listaView.clear();
        for (Pet p : lista) {
            if (p.getNome().contains(nome.get())) {
                listaView.add(p);
                //setEntity(p);
                //break;
            }
        }
    }

    public void remover(long id) {
        for ( Pet p : lista) {
            if(p.getId() == id) {
                lista.remove(p);
                break;
            }
        }
        atualizarListaView();
    }

    public void atualizarListaView() {
        listaView.clear();
        listaView.addAll(lista);
    }
    public ObservableList<Pet>  getListaView() {
        return listaView;
    }
}
