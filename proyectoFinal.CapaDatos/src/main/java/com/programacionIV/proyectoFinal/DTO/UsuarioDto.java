package com.programacionIV.proyectoFinal.DTO;

import java.util.Set;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String nombreUsuario;
	@NotBlank
	@Email
	private String correoElectronico;

	private String telefono;
	@NotBlank
	private String contrasenna;
@Nullable
	private int cliente;

	private Set<String> usuarioRol;

}
