package com.miniprojeto.trocadepontos.repository;

import com.miniprojeto.trocadepontos.model.UsuarioModel;
import org.hibernate.boot.JaccPermissionDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
