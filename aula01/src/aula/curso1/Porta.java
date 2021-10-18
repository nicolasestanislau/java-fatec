package aula.curso1;

public class Porta {
    boolean aberta;

    public void abrirPorta() {
        this.aberta = true;
        System.out.println("Porta aberta");
    }

    public void fecharPorta() {
        this.aberta = false;
        System.out.println("Porta fechada");
    }
}
