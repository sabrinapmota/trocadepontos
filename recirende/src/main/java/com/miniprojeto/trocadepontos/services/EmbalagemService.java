package com.miniprojeto.trocadepontos.services;

import com.miniprojeto.trocadepontos.enums.Troca;
import com.miniprojeto.trocadepontos.enums.factory.CalculoFactory;
import com.miniprojeto.trocadepontos.exceptions.EntityNotFoundException;
import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.repository.IEmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmbalagemService {

    @Autowired
    private IEmbalagemRepository repository;
    @Autowired
    private CalculoFactory calculoFactory;

    public List<EmbalagemModel> mostrarEmbalagens(){
        return repository.findAll();
    }

    public EmbalagemModel cadastrarEmbalagem(EmbalagemModel embalagemModel) {

        BigDecimal reposta = (BigDecimal) calculoFactory.CalculoPontuacao(embalagemModel.getTroca());
        return repository.save(embalagemModel);
    }

    public EmbalagemModel  alterarEmbalagem(Long id,EmbalagemModel embalagemModel){
        repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID not found " + id));
        return repository.save(embalagemModel);
    }

    public void deletarEmbalagem(Long idEmbalagem){
        repository.deleteById(idEmbalagem);
    }


}

