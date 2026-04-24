package com.example.demo.controller;

import com.example.demo.infrastructure.ConsertoRepository;
import com.example.demo.model.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados, UriComponentsBuilder uriBuilder){
        var conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping
    public Page<DadosListagemConserto> listar(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable)
                .map(DadosListagemConserto::new);
    }

    @GetMapping("/parcial")
    public List<DadosConsertosParcial> listarParcial(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable)
                .stream()
                .map(DadosConsertosParcial::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);

        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(conserto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();

        return ResponseEntity.noContent().build();
    }
}