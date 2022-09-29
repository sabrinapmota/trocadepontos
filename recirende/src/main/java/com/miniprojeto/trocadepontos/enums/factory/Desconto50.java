package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public class Desconto50 implements Calculo {

    @Override
    public BigDecimal calcular(UsuarioModel usuarioModel) {
        if (usuarioModel.getPontuacao().intValue() >= 6000) {
            BigDecimal newpoint1 = usuarioModel.getPontuacao().subtract(new BigDecimal("6000"));
            return newpoint1;
        } else {
            return null;
        }
    }
}
