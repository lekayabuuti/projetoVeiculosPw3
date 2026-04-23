package com.example.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record DadosVeiculo(String marca, String modelo, int ano) {
}
