package edu.curso.farmacia.control;

import edu.curso.farmacia.entidade.Medicamento;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoControl {

    private List<Medicamento> lista = new ArrayList<>();

    public void adicionar(Medicamento m) {
        lista.add(m);
        System.out.println(lista);
    }

    public Medicamento pesquisar(String nome) {
        for(Medicamento m : lista) {
            if (m.getNome().contains(nome)) {
                return m;
            }
        }
        return null;
    }
}
