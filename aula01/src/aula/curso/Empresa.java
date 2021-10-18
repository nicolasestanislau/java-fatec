package aula.curso;

public class Empresa {

    public static  void main(String[] args) {
        RecursosHumanos rh = new RecursosHumanos();
        Funcionario f1 = new Funcionario("Nicolas");
        Funcionario f2 = new Funcionario("Karine");
        Funcionario f3 = new Funcionario();

        f3.nome = "João";
        f3.cargo = "Designer";
        f3.salario = 4100.0f;

        rh.pagarFuncionario(f1, 250.0f, 400.0f);
        rh.pagarFuncionario(f2, 300.0f, 150.0f);
        rh.pagarFuncionario(f3);

//        rh.pagarFuncionario(f1, new float[] {250.0f, 400.0f});
//        rh.pagarFuncionario(f2, new float[] {300.0f});
//        rh.pagarFuncionario(f3, new float[] {});


    }
}
