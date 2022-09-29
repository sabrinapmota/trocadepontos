package com.miniprojeto.trocadepontos.enums.factory;


import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public class Celular implements Calculo {

    @Override
    public BigDecimal calcular(UsuarioModel usuarioModel) {
        if (usuarioModel.getPontuacao().intValue() >= 20000) {
            BigDecimal atualizandoPontucao = usuarioModel.getPontuacao().subtract(new BigDecimal("20000"));
            return atualizandoPontucao;
        } else {
            return null;
        }
    }
}
