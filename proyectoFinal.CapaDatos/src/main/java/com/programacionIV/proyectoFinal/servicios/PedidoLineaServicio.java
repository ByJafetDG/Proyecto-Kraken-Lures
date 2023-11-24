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
	
	public Page<PedidoLinea> listaPedidosLinea(Pageable pageable) {
		Page<PedidoLinea> pedidoLinea = pedidoLineaRepository.findAll(pageable);
		return pedidoLinea;
	}
	
	public Page<PedidoLinea> listaPedidosLineaFilteredId(List<Integer> linea, Pageable pageable) {
	    return pedidoLineaRepository.findByLineaIn(linea, pageable);
	}
	
}
