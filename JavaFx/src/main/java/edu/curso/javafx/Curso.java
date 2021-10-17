package edu.curso.javafx;

public class Curso {

    private long id = 0;
    private String nome = "";
    private long codCurso = 0;
    private String nomeCoordenador = "";
    private long qtdAlunos = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(long codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomeCoordenador() {
        return nomeCoordenador;
    }

    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
    }

    public long getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(long qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
