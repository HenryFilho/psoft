package psoft.lab1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class NotaDTO {

    private double nota;

    @JsonCreator
    public NotaDTO(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
