package com.programacionIV.proyectoFinal.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Producto;
import com.programacionIV.proyectoFinal.repositorio.ProductoRepository;

@Service
public class ProductoServicio {

	private final ProductoRepository productoRepository;

	public ProductoServicio(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	/**
	 * Retorna una lista completa de todos los productos existentes en la base de datos
	 * @param pageable se utiliza para paginar los json 
	 * @return List<Producto> en formato page
	 */
	public Page<Producto> listaProductos(Pageable pageable) {
		Page<Producto> productos = productoRepository.findAll(pageable);
		return productos;

	}

	/**
	 * Devuelve una lista de productos filtrada por una lista de categorias brindada
	 * 
	 * @param categoria es la lista que se recibe con las categorias que se
	 *                  filtrarán a la hora de devolver la lista
	 * @param pageable  objeto pageable que se utiliza para la paginación
	 * @return lista de objetos tipo producto
	 */
	public Page<Producto> listaProductoFiltered(List<String> categoria, Pageable pageable) {

		return productoRepository.findByCategoriaIn(categoria, pageable);

	}

	/**
	 * Devuelve una lista de string con las categorias de los productos que tengan
	 * cantidad mayor a 0, utilizando un query personalizado hacia la base de datos
	 * 
	 * @return List<String> de categorias
	 */
	public List<String> listaCategory() {
		return productoRepository.findDistinctCategory();
	}
	
	public void crearRegistro(Producto producto) {
		productoRepository.save(producto);
	}

}
