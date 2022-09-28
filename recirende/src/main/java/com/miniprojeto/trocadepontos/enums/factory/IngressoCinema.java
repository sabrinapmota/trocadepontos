package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public class IngressoCinema implements Calculo{


    @Override
    public BigDecimal calcular(UsuarioModel usuarioModel) {
        BigDecimal novaPontucao = usuarioModel.getPontuacao().subtract(new BigDecimal("500"));
        return novaPontucao;

    }//return usuarioModel.getPontuacao().subtract(new BigDecimal("500"));
}
