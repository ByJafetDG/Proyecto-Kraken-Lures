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

import com.programacionIV.proyectoFinal.DTO.PedidoDTO;
import com.programacionIV.proyectoFinal.entidades.Pedido;
import com.programacionIV.proyectoFinal.servicios.ClienteServicio;
import com.programacionIV.proyectoFinal.servicios.PedidoServicio;

@RestController
public class PedidoController {

	private final PedidoServicio pedidoServicio;
	private final ClienteServicio clienteServicio;

	public PedidoController(PedidoServicio pedidoServicio, ClienteServicio clienteServicio) {
		this.pedidoServicio = pedidoServicio;
		this.clienteServicio = clienteServicio;
	}

	@GetMapping(path = "/pedidos", produces = "application/json")
	public Page<Pedido> listadoPedidos(
			@PageableDefault(sort = "pedidoId", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<Pedido> consultarPedidos = pedidoServicio.obtenerPedidosPaginados(pageable);

		return consultarPedidos;
	}

	@GetMapping(path = "/pedidos/filteredById", produces = "application/json")
	public Page<Pedido> listadoPedidosFilteredId(
			@RequestParam(name = "pedidoId", required = true) List<Integer> pedidoId, Pageable pageable) {

		Page<Pedido> consultaPedidosId = pedidoServicio.obtenerPedidosFiltradosPorId(pedidoId, pageable);

		return consultaPedidosId;
	}

	@GetMapping(path = "/pedidos/filtered", produces = "application/json")
	public Page<Pedido> listadoPedidosFiltered(
			@RequestParam(name = "clienteId", required = true) List<Integer> clienteId, Pageable pageable) {

		Page<Pedido> consultaPedidos = pedidoServicio.obtenerPedidosFiltradosPorCliente(clienteId, pageable);

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

	@PostMapping("/pedidos/crearV2")
	public ResponseEntity postMethodName(@RequestBody PedidoDTO pedidoDTO) {
		Pedido pedido = Pedido.builder()
				.clienteId(clienteServicio.obtenerClientePorIdentificacion(pedidoDTO.getIdentificacion()))
				.fecha(pedidoDTO.getFecha())
				.enviado(false)
				.estado(false)
				.subtotal(pedidoDTO.getSubtotal())
				.impuesto(pedidoDTO.getImpuesto())
				.total(pedidoDTO.getTotal())
				.build();

		return ResponseEntity.ok().body(pedidoServicio.crearPedido(pedido));
	}

}
