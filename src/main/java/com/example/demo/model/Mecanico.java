package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anos_experiencia;

    public Mecanico(DadosMecanico dadosMecanico) {
        this.anos_experiencia = dadosMecanico.anos_experiencia();
        this.nome = dadosMecanico.nome();
    }
}

