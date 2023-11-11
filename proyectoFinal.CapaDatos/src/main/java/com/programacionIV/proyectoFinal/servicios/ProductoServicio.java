package com.programacionIV.proyectoFinal.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.programacionIV.proyectoFinal.entidades.Producto;
import com.programacionIV.proyectoFinal.repositorio.ProductoRepository;

@Service
public class ProductoServicio {

	private final ProductoRepository productoRepository;

	public ProductoServicio(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public Page<Producto> listaProductos(Pageable pageable) {
		Page<Producto> productos = productoRepository.findAll(pageable);
		return productos;

	}

	public Page<Producto> listaProductoFiltered(List<String> categoria, Pageable pageable) {
		

		return productoRepository.findByCategoriaIn(categoria, pageable);

	}
	
	public List<String> listaCategory(){
		return productoRepository.findDistinctCategory();
	}

}
