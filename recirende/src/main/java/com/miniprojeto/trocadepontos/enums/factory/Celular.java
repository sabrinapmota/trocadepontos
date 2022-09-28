package com.miniprojeto.trocadepontos.enums.factory;


import com.miniprojeto.trocadepontos.dto.UsuarioRequest;

import java.math.BigDecimal;

public class Celular implements Calculo{

    @Override
    public BigDecimal calcular(UsuarioRequest usuarioRequest) {
        BigDecimal atualizandoPontucao = usuarioRequest.getPontuacao().subtract(new BigDecimal("1500"));
        return atualizandoPontucao;

    }
}
