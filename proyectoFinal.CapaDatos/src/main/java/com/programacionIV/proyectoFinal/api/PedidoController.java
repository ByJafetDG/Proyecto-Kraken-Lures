package com.programacionIV.proyectoFinal.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacionIV.proyectoFinal.entidades.Pedido;
import com.programacionIV.proyectoFinal.servicios.PedidoServicio;

@RestController
public class PedidoController {
	
	private final PedidoServicio pedidoServicio;
	
	public PedidoController(PedidoServicio pedidoServicio) {
		this.pedidoServicio = pedidoServicio;
	}
	
	@GetMapping(path = "/pedidos", produces = "application/json")
	public Page<Pedido> listadoPedidos(@PageableDefault(sort = "pedidoId", direction = Sort.Direction.DESC)Pageable pageable){
		
		Page<Pedido> consultarPedidos = pedidoServicio.listaPedidos(pageable);
		
		return consultarPedidos;
	}
	
	@GetMapping(path = "/pedidos/filtered", produces = "application/json")
	public Page<Pedido> listadoPedidosFiltered(@RequestParam(name = "clienteId", required = true) List<Integer> clienteId, Pageable pageable){;
				
		Page<Pedido> consultaPedidos = pedidoServicio.listaPedidosFiltered(clienteId,pageable);
		
		return consultaPedidos;
	}
	
}