package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public interface Calculo {

    public BigDecimal calcular(UsuarioModel usuarioModel);

}
