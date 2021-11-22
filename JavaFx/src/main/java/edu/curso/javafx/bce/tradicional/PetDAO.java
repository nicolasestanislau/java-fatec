package edu.curso.javafx.bce.tradicional;

import java.util.List;

public interface PetDAO {
    void adicionar(Pet p);
    List<Pet> pesquisarPorNome(String nome);
    void atualizar(long id, Pet p);
    void remover(long id);

}
