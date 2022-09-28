package com.miniprojeto.trocadepontos.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
import com.fasterxml.jackson.annotation.*;
>>>>>>> d32411e5ffd5353a8412c080cd8d37a8dd9dfbe1
import com.miniprojeto.trocadepontos.enums.Troca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USUARIO")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUsuario")

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
<<<<<<< HEAD
    @Column
    private BigDecimal pontuacao;
    @Column
    private Troca troca;

=======
    private BigDecimal pontuacao = BigDecimal.ZERO;
    @Column
    private Troca troca;

    //@JsonIgnore
    //@JsonManagedReference
    //@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<EmbalagemModel> embalagemModels;
>>>>>>> d32411e5ffd5353a8412c080cd8d37a8dd9dfbe1

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
