package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idUsuario;
	private final String nombre;
	private final String cedula;
	private final String correo;
	private final int idRol;
	private final String tipoRol;
	private final String passwordHash;
	private final String tokenAuth;
	private final LocalDateTime fechaAuthExp;
	private final boolean estado;

	public Usuarios(int idUsuario, String nombre, String cedula, String correo, int idRol, String tipoRol, String passwordHash,
			String tokenAuth, LocalDateTime fechaAuthExp, boolean estado) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
		this.idRol = idRol;
		this.tipoRol = tipoRol;
		this.passwordHash = passwordHash;
		this.tokenAuth = tokenAuth;
		this.fechaAuthExp = fechaAuthExp;
		this.estado = estado;
	}

	public Usuarios(int idUsuario, String nombre, String cedula, String correo, int idRol, String tipoRol, String passwordHash) {
		this(idUsuario, nombre, cedula, correo, idRol, tipoRol, passwordHash, null, null, true);
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

	public int getIdRol() {
		return idRol;
	}

	/** Tipo del rol (ej. Admin, CLIENTE). Compatible con API que espera "rol" como string. */
	public String getRol() {
		return tipoRol;
	}

	public String getTipoRol() {
		return tipoRol;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getTokenAuth() {
		return tokenAuth;
	}

	public LocalDateTime getFechaAuthExp() {
		return fechaAuthExp;
	}

	public boolean isEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", nombre=" + nombre + ", cedula=" + cedula + ", correo=" + correo
				+ ", tipoRol=" + tipoRol + "]";
	}
}
