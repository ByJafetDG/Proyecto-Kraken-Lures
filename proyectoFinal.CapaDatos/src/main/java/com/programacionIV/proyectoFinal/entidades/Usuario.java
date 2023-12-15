package com.programacionIV.proyectoFinal.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID")
    private int usuarioId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO_1")
    private String apellido1;

    @Column(name = "APELLIDO_2")
    private String apellido2;
    
    @Column(name = "NOMBRE_USUARIO", unique = true) // Nueva columna para el nombre de usuario
    private String nombreUsuario;

    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "CONTRASEÑA")
    private String contrasenna;    

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_DE_USUARIO")
    private TipoDeUsuario tipoDeUsuario;

	public Usuario() {

	}

	/**
	 * @return the usuarioId
	 */
	public int getUsuarioId() {
		return usuarioId;
	}

	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
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
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	 * @return the contrasenna
	 */
	public String getContrasenna() {
		return contrasenna;
	}

	/**
	 * @param contrasenna the contrasenna to set
	 */
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
