package com.programacionIV.proyectoFinal.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Usuario;
import com.programacionIV.proyectoFinal.repositorio.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServicio {

	private final UsuarioRepository usuarioRepository;

	public UsuarioServicio(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	/**
	 * Obtiene una página de usuarios paginados.
	 *
	 * @param pageable información de paginación
	 * @return página de usuarios
	 */
	public Page<Usuario> obtenerUsuariosPaginados(Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}

	/**
	 * Obtiene una página de usuarios filtrados por un conjunto de IDs de apellido1.
	 *
	 * @param apellido1 lista de IDs de apellido1 para filtrar
	 * @param pageable  información de paginación
	 * @return página de usuarios filtrados por apellido1
	 */
	public Page<Usuario> obtenerUsuariosFiltrados(List<Integer> apellido1, Pageable pageable) {
		return usuarioRepository.findByUsuarioIdIn(apellido1, pageable);
	}
	
	@Transactional
    public Usuario crearUsuario(Usuario usuario) {
        // Lógica para la creación de usuario
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Integer id) {
        // Lógica para obtener usuario por ID
        return usuarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public Usuario actualizarUsuario(Integer id, Usuario usuario) {
        // Lógica para actualizar usuario
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            // Actualizar los campos necesarios
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido1(usuario.getApellido1());
            // ... actualizar otros campos según sea necesario

            return usuarioRepository.save(usuarioExistente);
        }
        return null; // Manejar caso donde el usuario no existe
    }

}
