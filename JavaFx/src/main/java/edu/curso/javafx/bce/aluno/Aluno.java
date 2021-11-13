package edu.curso.javafx.bce.aluno;

import java.time.LocalDate;

public class Aluno {
    private long id = 0;
    private long ra = 0;
    private String nome = "";
    private LocalDate nascimento = LocalDate.now();

    public long getId() {
        return id;
    }

    public long getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}

