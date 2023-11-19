package com.programacionIV.proyectoFinal.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Pedido;
import com.programacionIV.proyectoFinal.repositorio.PedidoRepository;

@Service
public class PedidoServicio {

	private final PedidoRepository pedidoRepository;
	
	public PedidoServicio(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public Page<Pedido> listaPedidos(Pageable pageable) {
		Page<Pedido> pedido = pedidoRepository.findAll(pageable);
		return pedido;
	}
	
	public Page<Pedido> listaPedidosFiltered(List<Integer> clienteId, Pageable pageable) {
		
		return pedidoRepository.findByClienteIdIn(clienteId, pageable);

	}
	/*
	public Page<Pedido> listaPedidosFiltradosPorFecha(Date fecha, Pageable pageable) {
        return pedidoRepository.findByFecha(fecha, pageable);
    }
	*/
}
