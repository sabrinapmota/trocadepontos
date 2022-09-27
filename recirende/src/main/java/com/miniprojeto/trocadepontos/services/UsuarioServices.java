package com.miniprojeto.trocadepontos.services;

import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServices {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> buscarId(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel) {
        usuarioModel.getNome();
        usuarioModel.getCpf();
        usuarioModel.getEmail();
        usuarioModel.getEndereco();
        usuarioModel.getEstado();

            }


}
        }
