package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;

import java.math.BigDecimal;

public class IngressoCinema implements Calculo{


    @Override
    public BigDecimal calcular(UsuarioRequest usuarioRequest) {
        BigDecimal novaPontucao = usuarioRequest.getPontuacao().subtract(new BigDecimal("500"));
        return novaPontucao;

    }//return usuarioModel.getPontuacao().subtract(new BigDecimal("500"));
}
