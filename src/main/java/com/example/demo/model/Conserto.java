package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data_entrada;
    private String data_saida;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;

    private boolean ativo;

    public Conserto(DadosConserto dadosConserto) {
        this.data_entrada = dadosConserto.data_entrada();
        this.data_saida = dadosConserto.data_saida();
        this.mecanico = new Mecanico(dadosConserto.mecanico());
        this.veiculo = new Veiculo(dadosConserto.veiculo());
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoConserto dados) {
        if (dados.data_entrada() != null) {
            this.data_entrada = dados.data_entrada();
        }
        if (dados.data_saida() != null) {
            this.data_saida = dados.data_saida();
        }
        if (dados.mecanico() != null) {
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
        if (dados.veiculo() != null) {
            this.veiculo.atualizarInformacoes(dados.veiculo());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
