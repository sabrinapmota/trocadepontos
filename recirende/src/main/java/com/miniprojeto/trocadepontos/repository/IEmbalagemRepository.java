package com.miniprojeto.trocadepontos.repository;

import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmbalagemRepository extends JpaRepository<EmbalagemModel, Long> {
}
