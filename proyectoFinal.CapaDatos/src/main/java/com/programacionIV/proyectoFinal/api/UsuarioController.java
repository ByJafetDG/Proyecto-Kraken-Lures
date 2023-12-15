package com.programacionIV.proyectoFinal.api;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.programacionIV.proyectoFinal.entidades.Usuario;
import com.programacionIV.proyectoFinal.servicios.UsuarioServicio;

@RestController
public class UsuarioController {

	private final UsuarioServicio usuarioServicio;

    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Page<Usuario>> obtenerUsuarios(
            @PageableDefault(sort = "usuarioId", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Usuario> consultarUsuarios = usuarioServicio.obtenerUsuariosPaginados(pageable);
        return ResponseEntity.ok().body(consultarUsuarios);
    }

    @GetMapping("/usuarios/filtrados")
    public ResponseEntity<Page<Usuario>> obtenerUsuariosFiltrados(
            @RequestParam(name = "apellido1", required = true) List<Integer> apellido1,
            Pageable pageable
    ) {
        Page<Usuario> consultaUsuarios = usuarioServicio.obtenerUsuariosFiltrados(apellido1, pageable);
        return ResponseEntity.ok().body(consultaUsuarios);
    }

    @PostMapping("/usuarios/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioServicio.crearUsuario(usuario);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nuevoUsuario.getUsuarioId())
                .toUri();
        return ResponseEntity.created(location).body(nuevoUsuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioServicio.obtenerUsuarioPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PutMapping("/usuarios/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioServicio.actualizarUsuario(id, usuario);
        return ResponseEntity.ok().body(usuarioActualizado);
    }

}
