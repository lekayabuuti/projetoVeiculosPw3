package com.example.demo.model;

import jakarta.persistence.*;
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

    public void atualizarInformacoes(DadosMecanico mecanico) {
        if (mecanico.nome() != null) {
            this.nome = mecanico.nome();
        }
        if (mecanico.anos_experiencia() != null) {
            this.anos_experiencia = mecanico.anos_experiencia();
        }
    }
}

