package com.programacionIV.proyectoFinal.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programacionIV.proyectoFinal.entidades.Pedido;



@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	Page<Pedido> findByPedidoIdIn(List<Integer> pedidoId, Pageable pageable);

	Page<Pedido> findByClienteIdIn(List<Integer> clienteId, Pageable pageable);
	/*
	Page<Pedido> findByFecha(LocalDate fecha, Pageable pageable);
	*/
}
