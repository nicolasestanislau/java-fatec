package aula.curso1;

public class Estacionamento {
    public static void main(String [] args) {
        Carro c1 = new Carro();
        c1.anoFabricacao = 2016;
        c1.fabricante = "GM";
        c1.modelo = "Onix";

        Pneu p = new Pneu();
        c1.p1 = p;

        Porta po = new Porta();
        c1.porta1 = po;

//        Motor m1 = new Motor();
//        c1.m1 = m;

    }
}
