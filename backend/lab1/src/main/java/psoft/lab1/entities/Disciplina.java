package psoft.lab1.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Disciplina {

    private String nome;
    private double nota;

    @JsonCreator
    public Disciplina(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "nome=" + nome + "\nnota=" + nota    ;
    }

}
