package com.miniprojeto.trocadepontos.services;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
import com.miniprojeto.trocadepontos.dto.UsuarioResponse;
import com.miniprojeto.trocadepontos.enums.factory.CalculoFactory;
import com.miniprojeto.trocadepontos.exceptions.EntityNotFoundException;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Optional<UsuarioModel> buscarId(Long idUsuario) {
        return Optional.ofNullable(usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + idUsuario)));
    }

    public UsuarioResponse cadastrarUsuario(UsuarioRequest usuarioRequest) {


        UsuarioModel usuarioModel = new UsuarioModel(null, usuarioRequest.getNome(), usuarioRequest.getCpf(),
                usuarioRequest.getEmail(), usuarioRequest.getEndereco(), usuarioRequest.getEstado(), usuarioRequest.getTroca());
        usuarioModel.setPontuacao(new BigDecimal("0"));

        usuarioRepository.save(usuarioModel);

        UsuarioResponse usuarioResponse = new UsuarioResponse(usuarioModel.getIdUsuario(), usuarioModel.getNome(), usuarioModel.getPontuacao());
        return usuarioResponse;
    }

    public List<UsuarioModel> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel alterarUser(Long idUsuario, UsuarioModel usuarioModel) {
        usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + idUsuario));

        UsuarioModel alterar = usuarioRepository.findById(usuarioModel.getIdUsuario()).get();

        BigDecimal retiradaDePontos = CalculoFactory.CalculoPontuacao(usuarioModel.getTroca()).calcular(alterar);
        alterar.setPontuacao(retiradaDePontos);
        alterar.setTroca(usuarioModel.getTroca());

        return usuarioRepository.save(alterar);

    }

    public void deletarUser(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}

