package com.miniprojeto.trocadepontos.controller;

import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarUsuario() {
        return ResponseEntity.ok().body(usuarioServices.buscarTodos());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok().body(usuarioServices.alterarUser(usuarioModel));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UsuarioModel>> buscarUserId(@PathVariable long id) {
        return ResponseEntity.ok().body(usuarioServices.buscarId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> cadastrarUser(@RequestBody UsuarioModel usuarioModel) {

        return ResponseEntity.ok().body(usuarioServices.cadastrarUsuario(usuarioModel));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioServices.deletarUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
