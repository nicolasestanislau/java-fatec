package aula.curso1;

public class MainAeroPorto{
    public static void main(String [] args) {
        Pessoa pessoaMain = new Pessoa("joão", 20, 60.0);
        System.out.println("Pessoa: \n" + "nome - " + pessoaMain.nome +'\n'
                + "idade - " + pessoaMain.idade +'\n' + "peso - " + pessoaMain.peso);

        Piloto piloto1 = new Piloto("Antonio", 43, 90.0 );
        piloto1.ferias = true;
        piloto1.salario = 12500.0f;

        System.out.printf(
                "Piloto: \n" + "nome - " + piloto1.nome+'\n'
                + "idade - " + piloto1.idade +'\n'
                + "peso - " + piloto1.peso + '\n'
                + "salario - " + "R$" + "%7.2f" ,piloto1.salario);
        if(piloto1.ferias){
            System.out.println("\npiloto esta de ferias");
        }else {
            System.out.println("\npiloto não esta de ferias");
        }

        Passageiro passegeiroMain = new Passageiro("Karine", 26, 58.8 );
        passegeiroMain.bagagemDeMao = false;
        passegeiroMain.passagem = "19238";
        System.out.println(
                "Passageiro: \n" + "nome - " + passegeiroMain.nome+'\n'
                + "idade - " + passegeiroMain.idade +'\n'
                + "peso - " + passegeiroMain.peso + '\n'
                + "numero de passagem - " +passegeiroMain.passagem);
        if(passegeiroMain.bagagemDeMao) {
            System.out.println("tem bagagem de mão");
        }else {
            System.out.println("não tem bagagem de mão");
        }

        Piloto p1 = new Piloto("João", 40, 80.0);
        p1.PilotoFuncao(p1.nome, p1.idade, p1.peso);

        AeroNave naveMain = new AeroNave();
        naveMain.assentos = 177;
        naveMain.velocidade = 850;

        AeroPorto aeroportoMain = new AeroPorto();
        aeroportoMain.internet = true;
        aeroportoMain.vagasEstacionamento = 340;

    }
}
