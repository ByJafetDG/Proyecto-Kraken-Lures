package com.programacionIV.proyectoFinal.DTO;

import java.time.LocalDate;

import com.programacionIV.proyectoFinal.entidades.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO {

  
	private String identificacion;

	private LocalDate fecha;

	private float subtotal;

	private float impuesto;

	private float total;
    
}
