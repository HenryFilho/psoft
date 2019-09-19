package psoft.lab1.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import psoft.lab1.dto.DisciplinaDTO;
import psoft.lab1.entities.Disciplina;

import java.util.ArrayList;
import java.util.List;

@Service
public class DisciplinaService {

    List<Disciplina> disciplinaList = new ArrayList<>();

    public DisciplinaDTO postDisciplina(Disciplina disciplina) {
        int id = disciplinaList.size();
        disciplinaList.add(disciplina);

        return new DisciplinaDTO(id, disciplina);
    }

    public List<DisciplinaDTO> getDisciplinas() {
        List<DisciplinaDTO> result = new ArrayList<>();

        for (int i = 0; i < disciplinaList.size(); i++) {
            if (disciplinaList.get(i) != null)
                result.add(new DisciplinaDTO(i, disciplinaList.get(i)));
        }

        return result;
    }

    public ResponseEntity<Disciplina> getDisciplina(int id) {
        return validateId(id)
                ? new ResponseEntity<Disciplina>(new DisciplinaDTO(id, disciplinaList.get(id)), HttpStatus.OK)
                : new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Disciplina> putNome(int id, String nome) {
        if (validateId(id)) disciplinaList.get(id).setNome(nome);
        return getDisciplina(id);
    }

    public ResponseEntity<Disciplina> putNota(int id, double nota) {
        if (validateId(id)) disciplinaList.get(id).setNota(nota);
        return getDisciplina(id);
    }

    public ResponseEntity<Disciplina> deleteDisciplina(int id) {
        ResponseEntity<Disciplina> result = getDisciplina(id);
        if (validateId(id)) disciplinaList.set(id, null);
        return result;
    }

    public List<DisciplinaDTO> getRanking() {
        List<DisciplinaDTO> result = new ArrayList<>();

        for (int i = 0; i < disciplinaList.size(); i++) {
            if (disciplinaList.get(i) != null)
                result.add(new DisciplinaDTO(i, disciplinaList.get(i)));
        }

        result.sort((d1, d2) -> (int) (d1.getNota() - d2.getNota()));

        return result;
    }

    private boolean validateId(int id) {
        if (disciplinaList.size() <= id)
            return false;
        return disciplinaList.get(id) != null;
    }
}
