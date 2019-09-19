package psoft.lab1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import psoft.lab1.entities.Disciplina;

public class DisciplinaDTO extends Disciplina {

    private final int id;

    @JsonCreator
    public DisciplinaDTO(int id, String nome, double nota) {
        super(nome, nota);
        this.id = id;
    }

    public DisciplinaDTO(int id, Disciplina disciplina) {
        this(id, disciplina.getNome(), disciplina.getNota());
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id + "\n" + super.toString();
    }
}
