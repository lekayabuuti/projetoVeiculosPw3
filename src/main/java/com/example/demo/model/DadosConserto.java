package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Embeddable
public record DadosConserto(
        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataEntrada,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,

        @Valid
        @NotNull
        DadosMecanico mecanico,

        @Valid
        @NotNull
        DadosVeiculo veiculo,

        @Valid
        @NotNull
        boolean ativo
) {
    public DadosConserto(Conserto conserto) {
        this( conserto.getDataEntrada(), conserto.getDataSaida(),
                new DadosMecanico(conserto.getMecanico()), new DadosVeiculo(conserto.getVeiculo()), conserto.isAtivo());
    }
}
