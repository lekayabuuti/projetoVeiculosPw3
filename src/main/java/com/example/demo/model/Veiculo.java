package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo{
    private String marca;
    private String modelo;
    private int ano;
    private String cor;

    public Veiculo(DadosVeiculo dadosVeiculo){
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.ano = dadosVeiculo.ano();
        this.cor = dadosVeiculo.cor();
    }

    public void atualizarInformacoes(DadosVeiculo veiculo) {
        if (veiculo.marca() != null) {
            this.marca = veiculo.marca();
        }
        if (veiculo.modelo() != null) {
            this.modelo = veiculo.modelo();
        }
        if (veiculo.ano() != null) {
            this.ano = veiculo.ano();
        }
        if (veiculo.cor() != null) {
            this.cor = veiculo.cor();
        }
    }
}
