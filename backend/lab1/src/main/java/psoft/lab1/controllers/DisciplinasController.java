package psoft.lab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import psoft.lab1.dto.DisciplinaDTO;
import psoft.lab1.dto.NomeDTO;
import psoft.lab1.dto.NotaDTO;
import psoft.lab1.entities.Disciplina;
import psoft.lab1.services.DisciplinaService;

import java.util.List;

@RestController
public class DisciplinasController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<DisciplinaDTO> postDisciplina(@RequestBody Disciplina disciplina) {
        return new ResponseEntity<DisciplinaDTO>(disciplinaService.postDisciplina(disciplina), HttpStatus.CREATED);
    }

    @GetMapping("/v1/api/disciplinas")
    public ResponseEntity<List<DisciplinaDTO>> getDisciplinas() {
        return new ResponseEntity<List<DisciplinaDTO>>(disciplinaService.getDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> getDisciplina(@PathVariable("id") int id) {
        return disciplinaService.getDisciplina(id);
    }

    @PutMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<Disciplina> putNome(@PathVariable("id") int id, @RequestBody NomeDTO nome) {
        return disciplinaService.putNome(id, nome.getNome());
    }

    @PutMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<Disciplina> putNota(@PathVariable("id") int id, @RequestBody NotaDTO nota) {
        return disciplinaService.putNota(id, nota.getNota());
    }

    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable("id") int id) {
        return disciplinaService.deleteDisciplina(id);
    }

    @GetMapping("/v1/api/disciplinas/ranking")
    public ResponseEntity<List<DisciplinaDTO>> getRanking() {
        return new ResponseEntity<List<DisciplinaDTO>>(disciplinaService.getRanking(), HttpStatus.OK);
    }
}
