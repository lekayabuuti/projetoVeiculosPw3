package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public record DadosVeiculo(
    String cor,

    @NotBlank
    String marca,

    @NotBlank
    String modelo,

    @NotNull
    Integer ano
) {
    public DadosVeiculo(Veiculo veiculo) {
        this( veiculo.getCor(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno());
    }
}
