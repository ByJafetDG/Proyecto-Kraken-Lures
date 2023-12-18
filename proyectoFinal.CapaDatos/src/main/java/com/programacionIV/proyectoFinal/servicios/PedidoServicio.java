package com.programacionIV.proyectoFinal.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Pedido;
import com.programacionIV.proyectoFinal.entidades.PedidoLinea;
import com.programacionIV.proyectoFinal.entidades.Producto;
import com.programacionIV.proyectoFinal.repositorio.PedidoLineaRepository;
import com.programacionIV.proyectoFinal.repositorio.PedidoRepository;
import com.programacionIV.proyectoFinal.repositorio.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoServicio {

	private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final PedidoLineaRepository pedidoLineaRepository;

	public PedidoServicio(PedidoRepository pedidoRepository, ProductoRepository productoRepository, PedidoLineaRepository pedidoLineaRepository) {
		this.pedidoRepository = pedidoRepository;
		this.productoRepository = productoRepository;
		this.pedidoLineaRepository = pedidoLineaRepository;
	}

    
    // Constructor y @Autowired

    public void procesarPedido(Map<String, Object> datosPedido) {
        List<Map<String, Object>> productosEnCarrito = (List<Map<String, Object>>) datosPedido.get("productos");

        // Crear un nuevo pedido
        Pedido pedido = new Pedido();
        // Puedes setear otros campos del pedido si es necesario
        pedidoRepository.save(pedido);

        // Procesar cada producto en el carrito
        for (Map<String, Object> productoData : productosEnCarrito) {
            // Crear un nuevo producto
            Producto producto = new Producto();
            producto.setNombre((String) productoData.get("NOMBRE"));
            // Setear otros campos del producto
            productoRepository.save(producto);

            // Crear una nueva línea de pedido asociada al producto y al pedido
            PedidoLinea pedidoLinea = new PedidoLinea();
            pedidoLinea.setPedido(pedido);
            pedidoLinea.setProducto(producto);
            // Setear otros campos de la línea de pedido
            pedidoLineaRepository.save(pedidoLinea);
        }
    }
	
	/**
	 * Obtiene una página de pedidos paginados.
	 *
	 * @param pageable información de paginación
	 * @return página de pedidos
	 */
	public Page<Pedido> obtenerPedidosPaginados(Pageable pageable) {
		return pedidoRepository.findAll(pageable);
	}

	/**
	 * Obtiene una página de pedidos filtrados por ID.
	 *
	 * @param pedidoId lista de IDs de pedidos
	 * @param pageable información de paginación
	 * @return página de pedidos filtrados
	 */
	public Page<Pedido> obtenerPedidosFiltradosPorId(List<Integer> pedidoId, Pageable pageable) {
		return pedidoRepository.findByPedidoIdIn(pedidoId, pageable);
	}

	/**
	 * Obtiene una página de pedidos filtrados por cliente ID.
	 *
	 * @param clienteId lista de IDs de clientes
	 * @param pageable  información de paginación
	 * @return página de pedidos filtrados por cliente
	 */
	public Page<Pedido> obtenerPedidosFiltradosPorCliente(List<Integer> clienteId, Pageable pageable) {
		return pedidoRepository.findByClienteIdIn(clienteId, pageable);
	}
	
	/*
	public Page<Pedido> listaPedidosFiltradosPorFecha(Date fecha, Pageable pageable) {
        return pedidoRepository.findByFecha(fecha, pageable);
    }
	*/
	
	
	@Transactional
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
	
}
