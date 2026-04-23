package com.example.demo.model;

import jakarta.persistence.*;
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
    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Veiculo veiculo;

    @Embedded
    private Mecanico mecanico;

    public Conserto(DadosConserto dadosConserto) {
        this.dataEntrada = dadosConserto.dataEntrada();
        this.dataSaida = dadosConserto.dataSaida();
        this.mecanico = dadosConserto.mecanico();
        this.veiculo = dadosConserto.veiculo();
    }
}
