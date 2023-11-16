package com.programacionIV.proyectoFinal.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacionIV.proyectoFinal.entidades.Usuario;
import com.programacionIV.proyectoFinal.servicios.UsuarioServicio;

@RestController
public class UsuarioController {
	
	private final UsuarioServicio usuarioServicio;
	
	public UsuarioController(UsuarioServicio usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}
	
	@GetMapping(path = "/usuarios", produces = "application/json")
	public Page<Usuario> listadoUsuarios(@PageableDefault(sort = "usuarioId", direction = Sort.Direction.DESC)Pageable pageable){
		
		Page<Usuario> consultarUsuarios = usuarioServicio.listaUsuarios(pageable);
		
		return consultarUsuarios;
	}
	
	@GetMapping(path = "/usuarios/filtered", produces = "application/json")
	public Page<Usuario> listadoUsuariosFiltered(@RequestParam(name = "apellido1", required = true) List<Integer> apellido1, Pageable pageable){;
				
		Page<Usuario> consultaUsuarios = usuarioServicio.listaUsuarioFiltered(apellido1,pageable);
		
		return consultaUsuarios;
	}
	
	
}
