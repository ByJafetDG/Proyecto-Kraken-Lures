package com.programacionIV.proyectoFinal.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacionIV.proyectoFinal.entidades.Cliente;
import com.programacionIV.proyectoFinal.servicios.ClienteServicio;
@RestController
public class ClienteController {
	
	private final ClienteServicio clienteServicio;
	
	public ClienteController(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}
	
	@GetMapping(path = "/clientes", produces = "application/json")
	public Page<Cliente> listadoClientes(@PageableDefault(sort = "identificacion", direction = Sort.Direction.DESC)Pageable pageable){
		
		Page<Cliente> consultarClientes = clienteServicio.listaClientes(pageable);
		
		return consultarClientes;
	}
	
	@GetMapping(path = "/clientes/filtered", produces = "application/json")
	public Page<Cliente> listadoClientesFiltered(@RequestParam(name = "tipoIdentificacion", required = true) List<Integer> tipoIdentificacion, Pageable pageable){;
				
		Page<Cliente> consultaClientes = clienteServicio.listaClienteFiltered(tipoIdentificacion,pageable);
		
		return consultaClientes;
	}
	
	
}
