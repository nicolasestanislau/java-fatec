package aula.curso1;

import aula.curso.Funcionario;

public class ConversorData {
    int ano;
    int mes;
    int dia;

    public ConversorData(){
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    public void dataJuliana(){
        int diaJuliano = ( 1461 * ( ano + 4800 + ( mes - 14)/12 )  ) / 4 +

                ( 367 * ( mes - 2- 12 * (  ( mes - 14)/12 )  ) ) /12 -

                ( 3 * ( ( ano + 4900 + ( mes - 14 ) / 12 ) / 100 )  ) / 4 + dia - 32075;

        System.out.println(diaJuliano);

    }


}
