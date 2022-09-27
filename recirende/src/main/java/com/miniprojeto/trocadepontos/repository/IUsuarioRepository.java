package com.miniprojeto.trocadepontos.repository;

import com.miniprojeto.trocadepontos.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
