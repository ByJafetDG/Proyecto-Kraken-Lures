package com.programacionIV.proyectoFinal.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Cliente;
import com.programacionIV.proyectoFinal.repositorio.ClienteRepository;

@Service
public class ClienteServicio {

	private final ClienteRepository clienteRepository;
	
	public ClienteServicio(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
		
	public Page<Cliente> listaClientes(Pageable pageable) {
		Page<Cliente> clientes = clienteRepository.findAll(pageable);
		return clientes;

	}
	
	public Page<Cliente> listaClienteFiltered(List<Integer> tipoIdentificacion, Pageable pageable) {
				
		return clienteRepository.findByTipoIdentificacionIn(tipoIdentificacion, pageable);

	}
	
}
