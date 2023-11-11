package com.programacionIV.proyectoFinal.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programacionIV.proyectoFinal.entidades.Producto;
import com.programacionIV.proyectoFinal.servicios.ProductoServicio;

@RestController
public class ProductoController {

	private final ProductoServicio productoServicio;

	public ProductoController(ProductoServicio productoServicio) {
		this.productoServicio = productoServicio;
	}

	@GetMapping(path = "/productos", produces = "application/json")
	public Page<Producto> listadoProductos(
			@PageableDefault(sort = "fechaInclusion", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<Producto> consultaProductos = productoServicio.listaProductos(pageable);

		return consultaProductos;

	}

	@GetMapping(path = "/productos/filtered", produces = "application/json")
	/**
	 * Devuelve una lista de productos filtrada mediante el query param
	 * "categorias", para utilizarlo se agrega en la URL
	 * "categorias=categoria1,categoria2"
	 * 
	 * @param categorias es la lista que se recibe del query params con las
	 *                   categorias que el api filtrará a la hora de devolver la
	 *                   lista
	 * @param pageable   objecto pageable que se utiliza para la paginación, se
	 *                   utiliza con el query param "page=n", tambien para modificar
	 *                   la cantidad de registros que mostraran por pagina con
	 *                   "size=n"
	 * @return json con una lista de objetos tipo producto
	 */
	public Page<Producto> listadoProductosFiltered(
			@RequestParam(name = "categorias", required = true) List<String> categorias, Pageable pageable) {
		;

		Page<Producto> consultaProductos = productoServicio.listaProductoFiltered(categorias, pageable);

		return consultaProductos;
	}

	@GetMapping(path = "/productos/categories", produces = "application/json")
	public List<String> listadoCategories() {
		return productoServicio.listaCategory();
	}
}
