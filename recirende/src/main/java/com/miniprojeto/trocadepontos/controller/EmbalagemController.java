package com.miniprojeto.trocadepontos.controller;

import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.services.EmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/embalagens")
@Validated
public class EmbalagemController {

    @Autowired
    private EmbalagemService service;

    @GetMapping
    public ResponseEntity<List<EmbalagemModel>> buscarEmbalagens() {
        List<EmbalagemModel> listaEmbalagens = service.mostrarEmbalagens();
        return ResponseEntity.ok(listaEmbalagens);
    }

    @GetMapping(path = "/{idEmbalagem}")
    public ResponseEntity<Optional<EmbalagemModel>> buscarEmbalagemId(@PathVariable Long idEmbalagem) {
        return ResponseEntity.ok().body(service.buscarId(idEmbalagem));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmbalagemModel> cadastrarEmbalagem(@Valid @RequestBody EmbalagemModel embalagem) {
        return ResponseEntity.ok(service.cadastrarEmbalagem(embalagem));
    }


    @PatchMapping(path = "/{idEmbalagem}")
    public ResponseEntity<EmbalagemModel> alterarEmbalagem(@Valid @PathVariable Long idEmbalagem, @RequestBody EmbalagemModel embalagem) {
        return ResponseEntity.ok(service.alterarEmbalagem(idEmbalagem, embalagem));
    }

    @DeleteMapping(path = "/{idEmbalagem}")
    public String deletarEmbalagem(@PathVariable Long idEmbalagem) {
        service.deletarEmbalagem(idEmbalagem);
        return "id " + idEmbalagem + " Deletado";
    }
}
