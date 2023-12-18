package com.programacionIV.proyectoFinal.api;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.relation.Role;

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

import com.programacionIV.proyectoFinal.DTO.UsuarioDto;
import com.programacionIV.proyectoFinal.entidades.Cliente;
import com.programacionIV.proyectoFinal.entidades.Roles;
import com.programacionIV.proyectoFinal.entidades.TipoDeRol;
import com.programacionIV.proyectoFinal.entidades.Usuario;
import com.programacionIV.proyectoFinal.servicios.ClienteServicio;
import com.programacionIV.proyectoFinal.servicios.UsuarioServicio;

import jakarta.validation.Valid;

@RestController
public class UsuarioController {

    private final UsuarioServicio usuarioServicio;

    private final ClienteServicio clienteServicio;

    public UsuarioController(UsuarioServicio usuarioServicio, ClienteServicio clienteServicio) {
        this.usuarioServicio = usuarioServicio;
        this.clienteServicio = clienteServicio;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Page<Usuario>> obtenerUsuarios(
            @PageableDefault(sort = "usuarioId", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Usuario> consultarUsuarios = usuarioServicio.obtenerUsuariosPaginados(pageable);
        return ResponseEntity.ok().body(consultarUsuarios);
    }

    @GetMapping("/usuarios/filtrados")
    public ResponseEntity<Page<Usuario>> obtenerUsuariosFiltrados(
            @RequestParam(name = "apellido1", required = true) List<Integer> apellido1,
            Pageable pageable) {
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

    @PostMapping("/usuarios/crear/v2")
    public ResponseEntity<String> crearUsuarioV2(@Valid @RequestBody UsuarioDto usuarioDto) {
        Set<Roles> roles = usuarioDto.getUsuarioRol().stream()
                .map(role -> Roles.builder()
                        .rol(TipoDeRol.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .nombre(usuarioDto.getNombre())
                .apellido1(usuarioDto.getApellido1())
                .nombreUsuario(usuarioDto.getNombreUsuario())
                .correoElectronico(usuarioDto.getCorreoElectronico())
                .telefono(usuarioDto.getTelefono())
                .contrasenna(usuarioDto.getContrasenna())
                .cliente(clienteServicio.obtenerClientePorId(usuarioDto.getCliente()))
                .usuarioRol(roles)
                .build();

        usuarioServicio.crearUsuario(usuario);

        return ResponseEntity.ok().body("Usuario creado");
    }

}
