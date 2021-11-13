package edu.curso.javafx.bce.curso;

public class Curso {
    private long id = 0;
    private long codCurso = 0;
    private String nome = "";
    private String coordenador = "";
    private long qntAlunos = 0;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getCodCurso() {
        return codCurso;
    }
    public void setCodCurso(long codCurso) {
        this.codCurso = codCurso;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenador() {
        return coordenador;
    }
    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public long getQntAlunos() {
        return qntAlunos;
    }
    public void setQntAlunos(long qntAlunos) {
        this.qntAlunos = qntAlunos;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
