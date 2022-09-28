package com.miniprojeto.trocadepontos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.miniprojeto.trocadepontos.enums.Troca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "embalagens")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEmbalagem")

public class EmbalagemModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmbalagem;

    @Column(length = 100)
    private String nomeMarca;

    @Column(length = 50)
    private Integer numeroSerie;

    @Column(length = 50)
    private LocalDate dataCadastro = LocalDate.now();

    @Column(length = 50)
    private BigDecimal pontoEmbalagem ;

    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;
}
