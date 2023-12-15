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

	/**
	 * Obtiene una página de pedidos paginados.
	 *
	 * @param pageable información de paginación
	 * @return página de pedidos
	 */
	public Page<Pedido> obtenerPedidosPaginados(Pageable pageable) {
		return pedidoRepository.findAll(pageable);
	}

	/**
	 * Obtiene una página de pedidos filtrados por ID.
	 *
	 * @param pedidoId lista de IDs de pedidos
	 * @param pageable información de paginación
	 * @return página de pedidos filtrados
	 */
	public Page<Pedido> obtenerPedidosFiltradosPorId(List<Integer> pedidoId, Pageable pageable) {
		return pedidoRepository.findByPedidoIdIn(pedidoId, pageable);
	}

	/**
	 * Obtiene una página de pedidos filtrados por cliente ID.
	 *
	 * @param clienteId lista de IDs de clientes
	 * @param pageable  información de paginación
	 * @return página de pedidos filtrados por cliente
	 */
	public Page<Pedido> obtenerPedidosFiltradosPorCliente(List<Integer> clienteId, Pageable pageable) {
		return pedidoRepository.findByClienteIdIn(clienteId, pageable);
	}
	
	/*
	public Page<Pedido> listaPedidosFiltradosPorFecha(Date fecha, Pageable pageable) {
        return pedidoRepository.findByFecha(fecha, pageable);
    }
	*/
}
