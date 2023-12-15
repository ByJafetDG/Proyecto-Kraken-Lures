package com.programacionIV.proyectoFinal.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programacionIV.proyectoFinal.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	Page<Cliente> findByTipoIdentificacionIn(List<Integer> tipoIdentificacion, Pageable pageable);

}
