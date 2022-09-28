package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public class Desconto30 implements Calculo{

    @Override
    public BigDecimal calcular(UsuarioModel usuarioModel) {
        BigDecimal newpoint1 = usuarioModel.getPontuacao().subtract(new BigDecimal("200"));
        return newpoint1;
    }
}
