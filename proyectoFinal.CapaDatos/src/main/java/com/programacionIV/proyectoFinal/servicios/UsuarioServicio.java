package com.programacionIV.proyectoFinal.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Usuario;
import com.programacionIV.proyectoFinal.repositorio.UsuarioRepository;

@Service
public class UsuarioServicio {
	
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioServicio(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Page<Usuario> listaUsuarios(Pageable pageable) {
		Page<Usuario> usuario = usuarioRepository.findAll(pageable);
		return usuario;
	}
	
	/*No se me ocurrio como filtrarlos, asi que lo hice por el primer apellido
	 * ya que muchos usuarios podrian tener el mismo primer apellido*/
	public Page<Usuario> listaUsuarioFiltered(List<Integer> apellido1, Pageable pageable) {
		
		return usuarioRepository.findByUsuarioIdIn(apellido1, pageable);

	}
	
	
}
