package com.example.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record DadosConserto( String dataEntrada, String dataSaida, Mecanico mecanico, Veiculo veiculo) {
}
