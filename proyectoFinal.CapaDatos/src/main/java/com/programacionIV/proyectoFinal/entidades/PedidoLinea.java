package com.programacionIV.proyectoFinal.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDO_LINEA")
public class PedidoLinea {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINEA")
    private int linea;
    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "PRODUCTO_ID")
    private Producto producto;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "SUBTOTAL")
    private float subtotal;
    @Column(name = "IMPUESTO")
    private float impuesto;
    @Column(name = "TOTAL")
    private float total;

    public PedidoLinea() {

    }

	/**
	 * @return the linea
	 */
	public int getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(int linea) {
		this.linea = linea;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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
