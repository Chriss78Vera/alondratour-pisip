package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idUsuario;
	private final String nombre;
	private final String cedula;
	private final String correo;
	private final String rol;
	
	
	public Usuarios(int idUsuario, String nombre, String cedula, String correo, String rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
		this.rol = rol;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public String getCorreo() {
		return correo;
	}
	public String getRol() {
		return rol;
	}

	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo
				+ ", rol=" + rol + "]";
	}


}
