package com.programacionIV.proyectoFinal.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.PedidoLinea;
import com.programacionIV.proyectoFinal.repositorio.PedidoLineaRepository;

@Service
public class PedidoLineaServicio {

	private final PedidoLineaRepository pedidoLineaRepository;

	public PedidoLineaServicio(PedidoLineaRepository pedidoLineaRepository) {
		this.pedidoLineaRepository = pedidoLineaRepository;
	}

	/**
	 * Obtiene una página de líneas de pedido paginadas.
	 *
	 * @param pageable información de paginación
	 * @return página de líneas de pedido
	 */
	public Page<PedidoLinea> obtenerLineasDePedidoPaginadas(Pageable pageable) {
		return pedidoLineaRepository.findAll(pageable);
	}

	/**
	 * Obtiene una página de líneas de pedido filtradas por ID.
	 *
	 * @param linea    lista de IDs de líneas de pedido
	 * @param pageable información de paginación
	 * @return página de líneas de pedido filtradas
	 */
	public Page<PedidoLinea> obtenerLineasDePedidoFiltradasPorId(List<Integer> linea, Pageable pageable) {
		return pedidoLineaRepository.findByLineaIn(linea, pageable);
	}

}
