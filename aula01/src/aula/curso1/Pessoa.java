package aula.curso1;

public class Pessoa {

    int idade;
    String nome;
    double peso;

    public Pessoa(String nome, int idade, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
    }

    public void falar() {
        System.out.println("falando...");
    }
}
