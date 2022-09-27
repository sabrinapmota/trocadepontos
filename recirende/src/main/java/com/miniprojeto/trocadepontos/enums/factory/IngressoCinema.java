package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.model.UsuarioModel;

import java.math.BigDecimal;

public class IngressoCinema implements Calculo{

    @Override
    public BigDecimal calcular(UsuarioModel usuarioModel) {
       //BigDecimal verificaPontuacaoUsuario = usuarioModel.getPontuacao();

        return usuarioModel.getPontuacao()
    }
}
