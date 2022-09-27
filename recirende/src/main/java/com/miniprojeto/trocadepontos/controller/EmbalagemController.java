package com.miniprojeto.trocadepontos.controller;

import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.services.EmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping (path = "/embalagens")
public class EmbalagemController {

    @Autowired
    private EmbalagemService service;

    @GetMapping
    public ResponseEntity<List<EmbalagemModel>> buscarEmbalagens(){
        List<EmbalagemModel> listaEmbalagens = service.mostrarEmbalagens();
        return ResponseEntity.ok(listaEmbalagens);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmbalagemModel> cadastrarEmbalagem(@RequestBody EmbalagemModel embalagem){
        return ResponseEntity.ok(service.cadastrarEmbalagem(embalagem));
    }

    @PutMapping (path ="/{id}")
    public ResponseEntity<EmbalagemModel> alterarEmbalagem(@RequestBody EmbalagemModel embalagem){
        return ResponseEntity.ok(service.alterarEmbalagem(embalagem));
    }

    @DeleteMapping (path = "/{id}")
    public void deletarEmbalagem(@PathVariable Long idEmbalagem){
        service.deletarEmbalagem(idEmbalagem);
    }
}
