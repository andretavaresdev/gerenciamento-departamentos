package com.tavares.gerenciamentodepartamentos.controllers;

import com.tavares.gerenciamentodepartamentos.models.Departamento;
import com.tavares.gerenciamentodepartamentos.services.DepartamentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoService service;

    @PostMapping
    public ResponseEntity<Departamento> salvar(@RequestBody Departamento departamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Departamento> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
