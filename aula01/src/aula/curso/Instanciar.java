package aula.curso;

public class Instanciar {
    public static void main(String[] args){
        Gato gato1 = new Gato();
        Gato gato2 = new Gato();

        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        Caneta caneta1 = new Caneta();
        Caneta caneta2 = new Caneta();

        gato1.tamanho = 1.4f;
        gato1.peso = 5.5f;
        gato1.nome = "Flash";
        gato1.cor = "Dourado";
        gato1.raca = "Persa";
        gato1.brincar();
        gato1.miar();
        gato1.comer();

        gato2.tamanho = 1.2f;
        gato2.peso = 4.5f;
        gato2.nome = "Cafú";
        gato2.cor = "Preto";
        gato2.raca = "Gato de pelo curto inglês";
        gato2.brincar();
        gato2.miar();
        gato2.comer();

        carro1.autonomia = 358.8f;
        carro1.maxKmHora = 120;
        carro1.marca = "Fiat";
        carro1.modelo = "Fiat Uno";
        carro1.ano = 2018;
        carro1.velocidade = 200;
        carro1.acelerar();
        carro1.frear();
        carro1.re();
        carro1.espacoLivre();

        carro2.autonomia = 258.8f;
        carro2.maxKmHora = 130;
        carro2.marca = "Volkswagen";
        carro2.modelo = "Gol";
        carro2.ano = 2019;
        carro2.acelerar();
        carro2.frear();
        carro2.re();

        caneta1.modelo = "BIC";
        caneta1.cor = "Azul";
        caneta1.ponta = 0.5;
        caneta1.carga = 90;
        caneta1.tampada = false;
        caneta1.rasbiscar();
        caneta1.escrever();
        caneta1.tampar();

        caneta2.modelo = "gel";
        caneta2.cor = "Vermelha";
        caneta2.ponta = 0.7;
        caneta2.carga = 50;
        caneta2.tampada = false;
        caneta2.rasbiscar();
        caneta2.escrever();
        caneta2.tampar();

    }
}
