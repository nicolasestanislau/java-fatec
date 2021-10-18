package aula.aula07;

import java.util.Arrays;

public class GrupoTrabalho<T> {

    int indice = 0;

    T[] membros;

    public GrupoTrabalho(T[] lista) {
        this.membros = lista;
    }

    public void adicionar(T f) {
        if ( indice < 10 ){
            membros[indice] = f;
            indice++;
        }
    }
}
