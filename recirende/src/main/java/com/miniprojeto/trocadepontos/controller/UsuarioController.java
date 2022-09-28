package com.miniprojeto.trocadepontos.controller;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
import com.miniprojeto.trocadepontos.dto.UsuarioResponse;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
@Validated
public class UsuarioController {
    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarUsuario() {
        return ResponseEntity.ok().body(usuarioServices.buscarTodos());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterarUsuario(@Valid @PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok().body(usuarioServices.alterarUser(id,usuarioModel));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UsuarioModel>> buscarUserId(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioServices.buscarId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastrarUser(@Valid @RequestBody UsuarioRequest usuarioRequest) {

        return ResponseEntity.ok().body(usuarioServices.cadastrarUsuario(usuarioRequest));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioServices.deletarUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
