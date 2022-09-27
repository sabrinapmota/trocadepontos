package com.miniprojeto.trocadepontos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "embalagens")
public class EmbalagemModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmbalagem;

    @Column(length = 100)
    private String nomeMarca;

    @Column(length = 50)
    private Integer numeroSerie;

    @Column(length = 50)
    private LocalDate dataCadastro;

    @Column(length = 50)
    private  Integer pontoEmbalagem;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;
}
