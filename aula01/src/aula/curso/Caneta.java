package aula.curso;

public class Caneta {
    String modelo;
    String cor;
    double ponta;
    int carga;
    Boolean tampada;

    public void rasbiscar() {
        if(tampada) {
            System.out.println("ERRO");
        }else{
            System.out.println("Rabisco");
        }
    }
    public void tampar() {
        tampada = true;
    }

    public void escrever(){
        if(tampada) {
            System.out.println("ERRO");
        }else {
            System.out.println("escrever");
        }
    }
}

