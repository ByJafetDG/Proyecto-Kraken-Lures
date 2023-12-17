package com.programacionIV.proyectoFinal.api;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

		Page<Pedido> consultarPedidos = pedidoServicio.obtenerPedidosPaginados(pageable);

		return consultarPedidos;
	}

	@GetMapping(path = "/pedidos/filteredById", produces = "application/json")
	public Page<Pedido> listadoPedidosFilteredId(@RequestParam(name = "pedidoId", required = true) List<Integer> pedidoId, Pageable pageable){

		Page<Pedido> consultaPedidosId = pedidoServicio.obtenerPedidosFiltradosPorId(pedidoId,pageable);

		return consultaPedidosId;
	}

	@GetMapping(path = "/pedidos/filtered", produces = "application/json")
	public Page<Pedido> listadoPedidosFiltered(@RequestParam(name = "clienteId", required = true) List<Integer> clienteId, Pageable pageable){

		Page<Pedido> consultaPedidos = pedidoServicio.obtenerPedidosFiltradosPorCliente(clienteId,pageable);

		return consultaPedidos;
	}
	
	@PostMapping("/pedidos/crear")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoServicio.crearPedido(pedido);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nuevoPedido.getPedidoId())
                .toUri();
        return ResponseEntity.created(location).body(nuevoPedido);
    }
	

}
