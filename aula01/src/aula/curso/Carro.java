package aula.curso;

public class Carro {
    float autonomia;
    int maxKmHora;
    String marca;
    String modelo;
    int ano;
    int velocidade;

    public void acelerar() {
        System.out.println(" Acelerando ... ");
        velocidade = velocidade + 10;
    }

    public void frear() {
        velocidade = velocidade - 20;
        System.out.println(" Freando ..." + velocidade);

    }

    public void re() {
        System.out.println("colocando em marcha re...");
        velocidade = --velocidade;
    }

    public int espacoLivre() {
        System.out.println("chegou aqui..");
        return this.ano;
    }

}
