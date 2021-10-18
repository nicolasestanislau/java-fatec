package aula.dinossauro;

public class Dinossauro {
    public int energia;
    public int velocidade;
    public int temperatura;
    public int humor;

    public void pular() {
        energia = energia - 10;
        velocidade = velocidade + 10;
        humor = humor + 10;
        System.out.println("Pulando\n" +
                "energia: " + energia + "\n" +
                "velociade: " + velocidade + "\n" +
                "humor: " + humor + "\n");
    }
    public void correr() {
        energia = energia - 10;
        velocidade = velocidade - 10;
        humor = humor + 10;
        System.out.println("Correndo\n" +
                "energia: " + energia + "\n" +
                "velocidade: " + velocidade + "\n" +
                "humor: " + humor + "\n");
    }
    public void comer() {
        energia = energia + 10;
        velocidade = velocidade - 10;
        humor = humor + 10;
        System.out.println("Comendo\n" +
                "energia: " + energia + "\n" +
                "velocidade: " + velocidade + "\n");
    }

    public void cantar() {
        energia = energia - 10;
        humor = humor + 10;
        System.out.println("Cantando\n" +
                "energia: " + energia + "\n" +
                "humor: " + humor + "\n");
    }

    public void tomarSol() {
        velocidade = velocidade - 10;
        temperatura = temperatura + 10;
        humor = humor + 10;
        System.out.println("Tomando sol\n" +
                "velocidade: " + velocidade + "\n" +
                "temperatura: " + temperatura + "\n" +
                "humor: " + humor + "\n");
    }

    public void ficarNaSombra() {
        energia = energia + 10;
        humor = humor - 10;
        temperatura = temperatura - 10;
        System.out.println("Ficando na sombra\n" +
                "valocidade: " + velocidade + "\n" +
                "temperatura: " + temperatura + "\n" +
                "humor: " + humor);
    }
}
