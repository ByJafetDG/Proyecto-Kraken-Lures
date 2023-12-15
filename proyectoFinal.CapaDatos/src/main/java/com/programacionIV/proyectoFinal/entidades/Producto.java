package com.programacionIV.proyectoFinal.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTO_ID")
    private int productoId;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "CATEGORIA")
	private String categoria;

	@Column(name = "SKU")
	private String sku;

	@Column(name = "IMAGEN")
	private String imagen;

	@Column(name = "PRECIO")
	private float precio;

	@Column(name = "CANTIDAD_EN_STOCK")
	private int cantidad;

	@Column(name = "IMPUESTO")
	private float impuesto;

	@Column(name = "FECHA_INCLUSION")
	private LocalDate fechaInclusion;

	@Column(name = "VECES_COMPRADO")
	private int vecesComprado;

	@Column(name = "ES_TENDENCIA")
	private boolean esTendencia;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	public Producto() {

	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public LocalDate getFechaInclusion() {
		return fechaInclusion;
	}

	public void setFechaInclusion(LocalDate fechaInclusion) {
		this.fechaInclusion = fechaInclusion;
	}

	public int getVecesComprado() {
		return vecesComprado;
	}

	public void setVecesComprado(int vecesComprado) {
		this.vecesComprado = vecesComprado;
	}

	public boolean isEsTendencia() {
		return esTendencia;
	}

	public void setEsTendencia(boolean esTendencia) {
		this.esTendencia = esTendencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
