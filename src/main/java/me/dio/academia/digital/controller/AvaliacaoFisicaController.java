package me.dio.academia.digital.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@Tag(name = "Avaliação Física")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @Operation(summary = "Adiciona uma avaliacao fisica")
    @GetMapping("/")
    public ResponseEntity<List<AvaliacaoFisica>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @Operation(summary = "Adiciona uma avaliacao fisica")
    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@Valid @RequestBody AvaliacaoFisicaForm form){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(form));
    }

    @Operation(summary = "Atualiza uma avaliacao fisica")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AvaliacaoFisica> update(@Valid @PathVariable Long id,
                                                  @Valid @RequestParam AvaliacaoFisicaUpdateForm form){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, form));
    }

    @Operation(summary = "Deleta uma avaliacao fisica")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete (@Valid @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Matricula deleted sucessfully");
    }

}
