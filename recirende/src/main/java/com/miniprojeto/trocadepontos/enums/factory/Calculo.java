package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;

import java.math.BigDecimal;

public interface Calculo {

    public BigDecimal calcular(UsuarioRequest usuarioRequest);

}
