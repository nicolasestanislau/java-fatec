package aula.curso1;

public class Carro {
    String fabricante;
    String modelo;
    int anoFabricacao;
    // agregação
    Pneu p1;
    Pneu p2;
    Pneu p3;
    Pneu p4;
    Porta porta1;
    Porta porta2;
    // composicao
    private Motor m1;

    public void acelerar() {
        System.out.println("Acelerando...");
    }
}
