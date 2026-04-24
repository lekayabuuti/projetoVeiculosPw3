package com.example.demo.model;

public record DadosListagemConserto(
      Long id, String data_entrada, String data_saida, Mecanico mecanico, Veiculo veiculo) {

    public DadosListagemConserto(Conserto conserto) {
        this(conserto.getId(), conserto.getData_entrada(), conserto.getData_saida(), conserto.getMecanico(), conserto.getVeiculo());
    }
}
