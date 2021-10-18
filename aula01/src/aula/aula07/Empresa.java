package aula.aula07;

public class Empresa {
    public static void main(String[] args) {
        FolhaPagamento df = new FolhaPagamentoDetalhes();
        GrupoTrabalho<Funcionario> grupo = new GrupoTrabalho<>(new Funcionario[10]);
        Funcionario joao = new Funcionario("Joao", 1500.00, 300.00, 275);

        Funcionario maria = new Funcionario("Maria", 1800.00, 400.00, 300);

        df.pagarSalario(joao);
        df.pagarSalario(maria);

        grupo.adicionar(joao);
        grupo.adicionar(maria);
        Aluno a1= new Aluno();
        GrupoTrabalho<Aluno> grupo2 = new GrupoTrabalho<>(new Aluno[10]);
        grupo2.adicionar(a1);



    }
}
