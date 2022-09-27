package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public interface Calculo {

    BigDecimal calcular(UsuarioModel usuarioModel);

}
