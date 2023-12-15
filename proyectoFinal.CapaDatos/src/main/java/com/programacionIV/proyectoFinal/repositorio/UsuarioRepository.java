package com.programacionIV.proyectoFinal.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programacionIV.proyectoFinal.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Page<Usuario> findByUsuarioIdIn(List<Integer> usuarioId, Pageable pageable);

}
