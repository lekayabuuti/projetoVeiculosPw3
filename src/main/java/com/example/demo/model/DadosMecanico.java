package com.example.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record DadosMecanico(String nome, int anos_experiencia) {
}
