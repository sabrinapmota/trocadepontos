package com.miniprojeto.trocadepontos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.miniprojeto.trocadepontos.enums.Troca;
>>>>>>> d32411e5ffd5353a8412c080cd8d37a8dd9dfbe1
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

<<<<<<< HEAD
   @JsonBackReference
=======
    //@JsonBackReference
>>>>>>> d32411e5ffd5353a8412c080cd8d37a8dd9dfbe1
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;
}
