package aula.curso;

public class RecursosHumanos {
    public void pagarFuncionario(Funcionario funcionario, float ... beneficios){
        float valorAPagar = funcionario.salario;
        for (int i = 0; i < beneficios.length; i++){
            valorAPagar = valorAPagar + beneficios[i];
        }
        System.out.printf("Foi pago R$ %7.2f ao funcionario %s %n", valorAPagar, funcionario.nome);
    }
//    public void pagarFuncionario(Funcionario funcionario, float beneficio1, float beneficio2){
//        float valorAPagar = funcionario.salario + beneficio1 + beneficio2;
//        System.out.printf("Foi pago R$ %7.2f ao funcionario %s %n", valorAPagar, funcionario.nome);
//    }
//
//    public void pagarFuncionario(Funcionario funcionario){
//        float valorAPagar = funcionario.salario;
//        System.out.printf("Foi pago R$ %7.2f ao funcionario %s %n", valorAPagar, funcionario.nome);
//    }
}
