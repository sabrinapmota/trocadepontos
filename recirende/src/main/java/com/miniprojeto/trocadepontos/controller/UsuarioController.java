package com.miniprojeto.trocadepontos.controller;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
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

    @PatchMapping(path = "/{idUsuario}")
    public ResponseEntity<UsuarioModel> alterarUsuario(@Valid @PathVariable Long idUsuario, @RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok().body(usuarioServices.alterarUser(idUsuario, usuarioModel));
    }

    @GetMapping(path = "/{idUsuario}")
    public ResponseEntity<Optional<UsuarioModel>> buscarUserId(@PathVariable Long idUsuario) {
        return ResponseEntity.ok().body(usuarioServices.buscarId(idUsuario));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> cadastrarUser(@Valid @RequestBody UsuarioRequest usuarioRequest) {

        return ResponseEntity.ok().body(usuarioServices.cadastrarUsuario(usuarioRequest));
    }

    @DeleteMapping(path = "/{idUsuario}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long idUsuario) {
        usuarioServices.deletarUser(idUsuario);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
