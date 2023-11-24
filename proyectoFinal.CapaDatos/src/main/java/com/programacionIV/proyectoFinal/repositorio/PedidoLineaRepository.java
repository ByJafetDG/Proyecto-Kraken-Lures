package com.programacionIV.proyectoFinal.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programacionIV.proyectoFinal.entidades.PedidoLinea;

@Repository
public interface PedidoLineaRepository extends JpaRepository<PedidoLinea, Integer> {

	Page<PedidoLinea> findByLineaIn(List<Integer> linea, Pageable pageable);

}
