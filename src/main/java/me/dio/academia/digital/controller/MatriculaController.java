package me.dio.academia.digital.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
@Tag(name = "Matrícula")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;
    @Operation(summary = "Adiciona uma nova matricula")
    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form){
        return service.create(form);
    }

    @Operation(summary = "Busca todas as matriculas por Bairro")
    @GetMapping
    public List<Matricula> getAll(
            @RequestParam(value = "Bairro", required = false) String bairro
    ){
        return service.getAll(bairro);
    }
}
