package com.miniprojeto.trocadepontos.enums.factory;

import com.miniprojeto.trocadepontos.enums.Troca;


public class CalculoFactory {

    public static Calculo CalculoPontuacao(Troca troca) {
        if (troca.equals(Troca.INGRESSO_CINEMA)) {
            return new IngressoCinema();
        } else if (troca.equals(Troca.DESCONTO_R$_30)) {
            return new Desconto30();

        } else if (troca.equals(Troca.CELULAR)) {
            return new Celular();

        } else {
            return null;
        }
    }
}



