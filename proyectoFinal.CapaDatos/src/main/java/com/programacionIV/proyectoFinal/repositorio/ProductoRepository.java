package com.programacionIV.proyectoFinal.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.programacionIV.proyectoFinal.entidades.Producto;
import java.util.List;

@Repository

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	/**
	 * Busca en la base de datos los productos filtrando por las categorias
	 * brindadas
	 * 
	 * @param categoria lista de categorias con la cual filtrará
	 * @param pageable  objeto pageable para el paginado de los json en el front
	 * @return lista de productos filtrada por categorias
	 */
	Page<Producto> findByCategoriaIn(List<String> categoria, Pageable pageable);

	/**
	 * Devuelve una lista de string con las categorias de los productos que tengan
	 * cantidad mayor a 0, utilizando un query personalizado hacia la base de datos
	 * 
	 * @return List<String> de categorias
	 */
	@Query("SELECT distinct(p.categoria) FROM Producto p where p.cantidad >0")
	List<String> findDistinctCategory();

}
