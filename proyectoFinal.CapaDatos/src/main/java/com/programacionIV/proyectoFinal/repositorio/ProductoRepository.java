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
	Page<Producto> findByCategoriaIn(List<String> categoria, Pageable pageable);
	
	@Query("SELECT distinct(p.categoria) FROM Producto p where p.cantidad >0")
	List<String>findDistinctCategory();

}
