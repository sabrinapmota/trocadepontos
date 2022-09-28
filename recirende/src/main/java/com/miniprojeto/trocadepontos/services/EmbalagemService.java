package com.miniprojeto.trocadepontos.services;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
import com.miniprojeto.trocadepontos.enums.Troca;
import com.miniprojeto.trocadepontos.enums.factory.CalculoFactory;
import com.miniprojeto.trocadepontos.exceptions.EntityNotFoundException;
import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.repository.IEmbalagemRepository;
import com.miniprojeto.trocadepontos.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmbalagemService {

    @Autowired
    private IEmbalagemRepository repository;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;


    public List<EmbalagemModel> mostrarEmbalagens(){
<<<<<<< HEAD
        List<EmbalagemModel > embalagemModels = repository.findAll();
        return embalagemModels;
=======
        List<EmbalagemModel> embalagens = repository.findAll();
        return embalagens;
>>>>>>> d32411e5ffd5353a8412c080cd8d37a8dd9dfbe1
    }

    public EmbalagemModel cadastrarEmbalagem(EmbalagemModel embalagemModel) {

        embalagemModel.setPontoEmbalagem(new BigDecimal(1500));

<<<<<<< HEAD
        //Buscar usuario através do "id" que está na embalagemModel
        //Com o usuario pegar get.Ponto
        UsuarioModel usuarioModel = usuarioRepository.findById(embalagemModel.getUsuario().getIdUsuario()).get();
        usuarioModel.setPontuacao(usuarioModel.getPontuacao().add(embalagemModel.getPontoEmbalagem()));
        usuarioRepository.save(usuarioModel);
=======
        UsuarioModel usuarioModel = usuarioRepository.findById(embalagemModel.getUsuario().getIdUsuario()).orElseThrow();
        usuarioModel.setPontuacao(usuarioModel.getPontuacao().add(embalagemModel.getPontoEmbalagem()));
        embalagemModel.setUsuario(usuarioModel);
>>>>>>> d32411e5ffd5353a8412c080cd8d37a8dd9dfbe1

        return repository.save(embalagemModel);
    }

    public EmbalagemModel  alterarEmbalagem(Long idEmbalagem,EmbalagemModel embalagemModel){

        repository.findById(idEmbalagem).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + idEmbalagem));
        return repository.save(embalagemModel);
    }

    public void deletarEmbalagem(Long idEmbalagem){
        repository.deleteById(idEmbalagem);
    }


    public Optional<EmbalagemModel> buscarId(Long idEmbalagem) {
        return Optional.ofNullable(repository.findById(idEmbalagem).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + idEmbalagem)));
    }
}

