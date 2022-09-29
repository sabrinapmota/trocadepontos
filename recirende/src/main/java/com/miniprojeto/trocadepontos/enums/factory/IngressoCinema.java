package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public class IngressoCinema implements Calculo{


    @Override
    public BigDecimal calcular(UsuarioModel usuarioModel) {

        if (usuarioModel.getPontuacao().intValue() >= 5000){
            BigDecimal novaPontucao = usuarioModel.getPontuacao().subtract(new BigDecimal("5000"));
            return novaPontucao;
        }else {
            return null;
        }



    }
}
