package com.miniprojeto.trocadepontos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USUARIO")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;


    @Column(nullable = false, unique = true, length = 30)
    private String nome;
    @Column(nullable = false, unique = true, length = 11)
    @JsonIgnore
    private String cpf;
    @Column(nullable = false, unique = true, length = 20)
    private String email;
    @Column(nullable = false, unique = false, length = 250)
    private String endereco;
    @Column(nullable = false, unique = true, length = 20)
    private String estado;
    private BigDecimal pontuacao;

    @OneToMany(mappedBy = "usuario", targetEntity = EmbalagemModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<EmbalagemModel> embalagemModels;


    public UsuarioModel(Object o, String nome, String cpf, String email, String endereco, String estado, BigDecimal pontuacao) {
    }
}
