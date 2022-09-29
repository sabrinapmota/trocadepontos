package com.miniprojeto.trocadepontos.enums.factory;


public class CalculoFactory {

    public static Calculo CalculoPontuacao(String troca) {
        if (troca.equalsIgnoreCase("INGRESSO_CINEMA")) {
            return new IngressoCinema();
        } else if (troca.equalsIgnoreCase("DESCONTO_R$_30")) {
            return new Desconto50();
        } else if (troca.equalsIgnoreCase("CELULAR")) {
            return new Celular();
        } else {
            return null;
        }
    }
}



