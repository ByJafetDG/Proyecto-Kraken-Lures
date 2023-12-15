package com.programacionIV.proyectoFinal.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Cliente;
import com.programacionIV.proyectoFinal.repositorio.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicio {

	private final ClienteRepository clienteRepository;

    public ClienteServicio(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Obtiene una página de clientes paginados.
     *
     * @param pageable información de paginación
     * @return página de clientes
     */
    public Page<Cliente> obtenerClientesPaginados(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    /**
     * Obtiene una página de clientes filtrados por tipo de identificación.
     *
     * @param tipoIdentificacion lista de tipos de identificación
     * @param pageable           información de paginación
     * @return página de clientes filtrados
     */
    public Page<Cliente> obtenerClientesFiltrados(List<Integer> tipoIdentificacion, Pageable pageable) {
        return clienteRepository.findByTipoIdentificacionIn(tipoIdentificacion, pageable);
    }

    /**
     * Crea un nuevo cliente.
     *
     * @param cliente cliente a crear
     * @return cliente creado
     */
    @Transactional
    public Cliente crearCliente(Cliente cliente) {
        // Lógica para la creación de cliente
        return clienteRepository.save(cliente);
    }

    /**
     * Obtiene un cliente por su identificación.
     *
     * @param identificacion identificación del cliente
     * @return cliente encontrado
     */
    public Cliente obtenerClientePorIdentificacion(Integer identificacion) {
        // Lógica para obtener cliente por identificación
        return clienteRepository.findById(identificacion).orElse(null);
    }

    /**
     * Actualiza la información de un cliente.
     *
     * @param identificacion    identificación del cliente a actualizar
     * @param cliente nueva información del cliente
     * @return cliente actualizado
     */
    @Transactional
    public Cliente actualizarCliente(Integer identificacion, Cliente cliente) {
        // Lógica para actualizar cliente
        Cliente clienteExistente = clienteRepository.findById(identificacion).orElse(null);
        if (clienteExistente != null) {
            // Actualizar los campos necesarios
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido1(cliente.getApellido1());
            // ... actualizar otros campos según sea necesario

            return clienteRepository.save(clienteExistente);
        }
        return null; // Manejar caso donde el cliente no existe
    }

}
