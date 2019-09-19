package psoft.lab1.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class NomeDTO {

    private String nome;

    @JsonCreator
    public NomeDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
