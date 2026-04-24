package com.example.demo.controller;

import com.example.demo.infrastructure.ConsertoRepository;
import com.example.demo.model.Conserto;
import com.example.demo.model.DadosConserto;
import com.example.demo.model.DadosConsertosParcial;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosConserto conserto){
        repository.save(new Conserto(conserto));
    }

    @GetMapping
    public Page<DadosConserto> listar(Pageable pageable) {
        return repository.findAll(pageable)
                .map(DadosConserto::new);
    }

    @GetMapping("/parcial")
    public List<DadosConsertosParcial> listarParcial() {
        return repository.findAll()
                .stream()
                .map(DadosConsertosParcial::new).filter(DadosConsertosParcial::ativo)
                .toList();
    }
}