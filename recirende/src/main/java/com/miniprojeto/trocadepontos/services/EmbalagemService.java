package com.miniprojeto.trocadepontos.services;

import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.repository.IEmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmbalagemService {

    @Autowired
    private IEmbalagemRepository repository;

    public List<EmbalagemModel> mostrarEmbalagens(){
        return repository.findAll();
    }

    public EmbalagemModel cadastrarEmbalagem(EmbalagemModel embalagemModel) {
        return repository.save(embalagemModel);
    }

    public EmbalagemModel  alterarEmbalagem(Long id,EmbalagemModel embalagemModel){
        return  repository.save(id ,embalagemModel);
    }

    public void deletarEmbalagem(Long idEmbalagem){
        repository.deleteById(idEmbalagem);
    }


}

