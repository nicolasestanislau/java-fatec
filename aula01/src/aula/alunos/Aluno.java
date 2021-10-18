package aula.alunos;
import java.util.Date;
public class Aluno {
    public long id;
    String nascimento;
    String ra;
    public String nome;

    public String toString(){
        return "Dados do aluno:"+ this.id + this.nascimento + this.ra + this.nome;
    }
}
