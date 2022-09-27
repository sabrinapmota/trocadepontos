package com.miniprojeto.trocadepontos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USUARIO")
public class UsuarioModel {
<<<<<<< HEAD

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
=======
    private long id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> 5cdf41e845af7a84b228c2e23f1197af63759ccb
    @Column(nullable = false, unique = true, length = 30)
    private String nome;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(nullable = false, unique = true, length = 20)
    private String email;
    @Column(nullable = false, unique = false, length = 255)
    private String endereco;
<<<<<<< HEAD
    @Column(nullable = false, unique = true, length = 20)
    private String estado;
    private Integer pontuacao;
=======
>>>>>>> 5cdf41e845af7a84b228c2e23f1197af63759ccb
}
