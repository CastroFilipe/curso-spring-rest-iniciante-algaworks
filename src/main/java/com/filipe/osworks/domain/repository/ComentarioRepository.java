package com.filipe.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filipe.osworks.domain.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
