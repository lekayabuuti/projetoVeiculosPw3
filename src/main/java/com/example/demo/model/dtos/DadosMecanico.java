package com.example.demo.model.dtos;

import com.example.demo.model.Mecanico;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record DadosMecanico(
        @NotBlank
        String nome,

        Integer anos_experiencia
) {
    public DadosMecanico(Mecanico mecanico) {
        this( mecanico.getNome(), mecanico.getAnos_experiencia());
    }
}
