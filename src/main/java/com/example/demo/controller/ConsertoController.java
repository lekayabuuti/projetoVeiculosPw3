package com.example.demo.controller;

import com.example.demo.infrastructure.ConsertoRepository;
import com.example.demo.model.Conserto;
import com.example.demo.model.DadosConserto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosConserto conserto){
        repository.save( new Conserto(conserto));
    }
}
