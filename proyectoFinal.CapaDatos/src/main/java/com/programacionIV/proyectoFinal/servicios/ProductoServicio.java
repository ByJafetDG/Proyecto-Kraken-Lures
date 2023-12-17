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
	 * Obtiene una página de productos paginados.
	 *
	 * @param pageable información de paginación
	 * @return página de productos
	 */
	public Page<Producto> obtenerProductosPaginados(Pageable pageable) {
		return productoRepository.findAll(pageable);
	}

	/**
	 * Obtiene una página de productos filtrados por categoría.
	 *
	 * @param categorias lista de categorías para filtrar
	 * @param pageable   información de paginación
	 * @return página de productos filtrados por categoría
	 */
	public Page<Producto> obtenerProductosFiltradosPorCategoria(List<String> categorias, Pageable pageable) {
		return productoRepository.findByCategoriaIn(categorias, pageable);
	}

	/**
	 * Obtiene una lista de categorías de productos que tienen una cantidad mayor a 0.
	 *
	 * @return lista de categorías
	 */
	public List<String> obtenerCategoriasConStock() {
		return productoRepository.findDistinctCategory();
	}
	
	public Page<Producto> obtenerProductosTendendia(Pageable pageable){
		return productoRepository.findProductosTendencia(pageable);
	}

	/**
	 * Crea un nuevo registro de producto.
	 *
	 * @param producto el producto a ser creado
	 */
	public void crearProducto(Producto producto) {
		productoRepository.save(producto);
	}

}
