package com.miniprojeto.trocadepontos.services;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
import com.miniprojeto.trocadepontos.dto.UsuarioResponse;
import com.miniprojeto.trocadepontos.exceptions.EntityNotFoundException;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> buscarId(Long id) {
        return Optional.ofNullable(usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id)));
    }

    public UsuarioResponse cadastrarUsuario(UsuarioRequest usuarioRequest) {
        UsuarioModel usuarioModel = new UsuarioModel(null, usuarioRequest.getNome(), usuarioRequest.getCpf(),
                usuarioRequest.getEmail(), usuarioRequest.getEndereco(), usuarioRequest.getEstado(),
                usuarioRequest.getPontuacao());
        usuarioRepository.save(usuarioModel);

        UsuarioResponse usuarioResponse = new UsuarioResponse(usuarioModel.getNome(), usuarioModel.getPontuacao());
        return usuarioResponse;
    }

    public List<UsuarioModel> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel alterarUser(Long id, UsuarioModel usuarioModel) {
        usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id));
        return usuarioRepository.save(usuarioModel);
    }

    public void deletarUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}

