package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(
    @NotNull
    Long id,

    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
    String data_entrada,

    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
    String data_saida,

    DadosMecanico mecanico,
    DadosVeiculo veiculo
) {}
