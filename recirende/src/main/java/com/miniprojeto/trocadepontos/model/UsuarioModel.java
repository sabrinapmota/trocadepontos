package com.miniprojeto.trocadepontos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miniprojeto.trocadepontos.enums.Troca;
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


    @Column()
    private String nome;
    @Column()
    private String cpf;
    @Column()
    private String email;
    @Column()
    private String endereco;
    @Column()
    private String estado;
    private BigDecimal pontuacao;
    @Column
    private Troca troca;

//    @OneToMany(mappedBy = "usuario", targetEntity = EmbalagemModel.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    List<EmbalagemModel> embalagemModels;

}
