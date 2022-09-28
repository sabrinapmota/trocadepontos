package com.miniprojeto.trocadepontos.dto;

import com.miniprojeto.trocadepontos.enums.Troca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    @NotEmpty
    private String nome;
    @CPF
    private String cpf;
    @Email
    private String email;
    @NotEmpty
    private String endereco;
    @NotEmpty
    private String estado;

    private Troca troca = null;

}
