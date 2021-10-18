package aula.curso1;

public class Passageiro extends Pessoa {

    String passagem;
    boolean bagagemDeMao;
    String identidade;

   Pessoa passageiro1 = new Pessoa(nome, idade, peso);

    void doThings() {
        passageiro1.falar();
    }

    public Passageiro(String nome, int idade, double peso) {
        super(nome, idade,peso);
    }

    void voo(){
        System.out.println("em voo...");
    }
}
