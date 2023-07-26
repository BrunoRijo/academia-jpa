package me.dio.academia.digital.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/alunos", produces = {"application/json"})
@Tag(name = "Aluno")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @Operation(summary = "Busca o aluno pelo ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> getById(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.get(id));
    }

    @Operation(summary = "Adiciona um aluno")
    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoForm form){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(form));
    }

    @Operation(summary = "Edita um aluno pelo ID")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Aluno> update(@Valid @PathVariable("id") Long id,
                        @Valid @RequestBody AlunoUpdateForm form){
       return ResponseEntity.status(HttpStatus.OK).body(service.update(id, form));
    }

    @Operation(summary = "Deleta um aluno pelo id")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@Valid @PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully");
    }

    @Operation(summary = "Busca todas as avaliacoes já realizadas por ID do aluno")
    @GetMapping(value = "/avaliacoes/{id}")
    public ResponseEntity<List<AvaliacaoFisica>> getAllAvaliacoesId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllAvaliacoesId(id));
    }

    @Operation(summary = "Busca todos os alunos")
    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(
            @RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento
    ){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll(dataDeNascimento));
    }
}
