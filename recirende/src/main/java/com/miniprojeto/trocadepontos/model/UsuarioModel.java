package com.miniprojeto.trocadepontos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.miniprojeto.trocadepontos.enums.Troca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    @JsonIgnore
    private String cpf;
    @Column()
    private String email;
    @Column()
    private String endereco;
    @Column()
    private String estado;
    @Column
    private BigDecimal pontuacao;
    @Column
    private Troca troca;


    public UsuarioModel(Long idUsuario, String nome, String cpf, String email, String endereco, String estado, Troca troca) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.estado = estado;
        this.troca = troca;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<EmbalagemModel> embalagemModels = new ArrayList<>();
}
