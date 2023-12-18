package com.programacionIV.proyectoFinal.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PEDIDO_ID")
	private int pedidoId;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente clienteId;

	@Column(name = "FECHA")
	private LocalDate fecha;

	@Column(name = "ESTADO")
	private boolean estado; 

	@Column(name = "ENVIADO")
	private boolean enviado;

	@Column(name = "SUBTOTAL")
	private float subtotal;

	@Column(name = "IMPUESTO")
	private float impuesto;

	@Column(name = "TOTAL")
	private float total;

	public Pedido() {

	}

	/**
	 * @return the pedidoId
	 */
	public int getPedidoId() {
		return pedidoId;
	}

	/**
	 * @param pedidoId the pedidoId to set
	 */
	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}

	/**
	 * @return the clienteId
	 */
	public Cliente getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the estado
	 */
	public boolean getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * @return the enviado
	 */
	public boolean isEnviado() {
		return enviado;
	}

	/**
	 * @param enviado the enviado to set
	 */
	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

	/**
	 * @return the subtotal
	 */
	public float getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the impuesto
	 */
	public float getImpuesto() {
		return impuesto;
	}

	/**
	 * @param impuesto the impuesto to set
	 */
	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

}
