package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public record DadosConsertosParcial(
        @NotBlank
        Long id,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataEntrada,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        @NotBlank
        String nome,

        @NotBlank
        String marca,

        @NotBlank
        String modelo

) {
    public DadosConsertosParcial(Conserto conserto) {
        this(conserto.getId(), conserto.getData_entrada(), conserto.getData_saida(),
                conserto.getMecanico().getNome(), conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo());
    }
}
