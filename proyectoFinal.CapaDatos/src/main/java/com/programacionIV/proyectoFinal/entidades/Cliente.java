package com.programacionIV.proyectoFinal.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENTE_ID")
    private int clienteId;
	
	@Column(name = "TIPO_IDENTIFICACION")
	private int tipoIdentificacion;

	@Column(name = "IDENTIFICACION")
	private String identificacion;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO_1")
	private String apellido1;

	@Column(name = "APELLIDO_2")
	private String apellido2;

	@Column(name = "PROVINCIA")
	private String provincia;

	@Column(name = "CANTON")
	private String canton;

	@Column(name = "DISTRITO")
	private String distrito;

	@Column(name = "DIRECCION_DETALLE")
	private String direccionDetalle;

	@Column(name = "CORREO_ELECTRONICO")
	private String correoElectronico;

	@Column(name = "TELEFONO")
	private String telefono;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "cliente")
	private Usuario usuario;


	public Cliente() {

	}


	/**
	 * @return the clienteId
	 */
	public int getClienteId() {
		return clienteId;
	}


	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}


	/**
	 * @return the tipoIdentificacion
	 */
	public int getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	/**
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(int tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}


	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}


	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}


	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}


	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	/**
	 * @return the canton
	 */
	public String getCanton() {
		return canton;
	}


	/**
	 * @param canton the canton to set
	 */
	public void setCanton(String canton) {
		this.canton = canton;
	}


	/**
	 * @return the distrito
	 */
	public String getDistrito() {
		return distrito;
	}


	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	/**
	 * @return the direccionDetalle
	 */
	public String getDireccionDetalle() {
		return direccionDetalle;
	}


	/**
	 * @param direccionDetalle the direccionDetalle to set
	 */
	public void setDireccionDetalle(String direccionDetalle) {
		this.direccionDetalle = direccionDetalle;
	}


	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}


	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
