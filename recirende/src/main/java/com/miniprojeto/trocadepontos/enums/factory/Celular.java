package com.miniprojeto.trocadepontos.enums.factory;


import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public class Celular implements Calculo{

    @Override
    public BigDecimal calcular(UsuarioModel usuarioModel) {
        BigDecimal atualizandoPontucao = usuarioModel.getPontuacao().subtract(new BigDecimal("1500"));
        return atualizandoPontucao;

    }
}
