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

import com.programacionIV.proyectoFinal.entidades.Cliente;
import com.programacionIV.proyectoFinal.servicios.ClienteServicio;
@RestController
public class ClienteController {

	private final ClienteServicio clienteServicio;

    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping("/clientes")
    public ResponseEntity<Page<Cliente>> obtenerClientes(
            @PageableDefault(sort = "clienteId", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Cliente> consultarClientes = clienteServicio.obtenerClientesPaginados(pageable);
        return ResponseEntity.ok().body(consultarClientes);
    }

    @GetMapping("/clientes/filtrados")
    public ResponseEntity<Page<Cliente>> obtenerClientesFiltrados(
            @RequestParam(name = "tipoIdentificacion", required = true) List<Integer> tipoIdentificacion,
            Pageable pageable
    ) {
        Page<Cliente> consultaClientes = clienteServicio.obtenerClientesFiltrados(tipoIdentificacion, pageable);
        return ResponseEntity.ok().body(consultaClientes);
    }

    @PostMapping("/clientes/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteServicio.crearCliente(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{identificacion}")
                .buildAndExpand(nuevoCliente.getIdentificacion())
                .toUri();
        return ResponseEntity.created(location).body(nuevoCliente);
    }

    @GetMapping("/clientes/{identificacion}")
    public ResponseEntity<Cliente> obtenerClientePorIdentificacion(@PathVariable Integer identificacion) {
        Cliente cliente = clienteServicio.obtenerClientePorIdentificacion(identificacion);
        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping("/clientes/actualizar/{identificacion}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable Integer identificacion,
            @RequestBody Cliente cliente
    ) {
        Cliente clienteActualizado = clienteServicio.actualizarCliente(identificacion, cliente);
        return ResponseEntity.ok().body(clienteActualizado);
    }

}
