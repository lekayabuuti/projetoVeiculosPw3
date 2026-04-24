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
        String data_entrada,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String data_saida,

        @Valid
        @NotNull
        DadosMecanico mecanico,

        @Valid
        @NotNull
        DadosVeiculo veiculo
) {
    public DadosConserto(Conserto conserto) {
        this( conserto.getData_entrada(), conserto.getData_saida(),
                new DadosMecanico(conserto.getMecanico()), new DadosVeiculo(conserto.getVeiculo()));
    }
}
