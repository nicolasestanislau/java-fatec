package aula.curso1;

public class Piloto extends Pessoa {
    float salario;
    String licenca;
    boolean ferias;

    public Piloto(String nome, int idade, double peso) {
        super(nome, idade, peso);
    }

    public void  PilotoFuncao(String nome, int idade, double peso) {
        nome = "outro nome";

        System.out.println("teste: " + nome);
    }


    void voo() {
        System.out.println("em voo...");
    }
}
