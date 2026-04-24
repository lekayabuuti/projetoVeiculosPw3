package com.example.demo.model;

public record DadosDetalhamentoConserto(
        Long id, String data_entrada, String data_saida, Mecanico mecanico, Veiculo veiculo, Boolean ativo) {

    public DadosDetalhamentoConserto(Conserto conserto) {
        this(conserto.getId(), conserto.getData_entrada(), conserto.getData_saida(), conserto.getMecanico(), conserto.getVeiculo(), conserto.isAtivo());
    }
}
