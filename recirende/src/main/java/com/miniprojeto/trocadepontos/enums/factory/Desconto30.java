package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;

import java.math.BigDecimal;

public class Desconto30 implements Calculo{

    @Override
    public BigDecimal calcular(UsuarioRequest usuarioRequest) {
        BigDecimal newpoint1 = usuarioRequest.getPontuacao().subtract(new BigDecimal("200"));
        return newpoint1;
    }
}
