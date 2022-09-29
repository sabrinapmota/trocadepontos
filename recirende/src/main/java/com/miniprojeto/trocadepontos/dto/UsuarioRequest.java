package com.miniprojeto.trocadepontos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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


    private String troca;

}
