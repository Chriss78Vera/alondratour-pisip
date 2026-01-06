package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;

public class UsuarioReservas implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idUsuarioReserva;
	private final int idUsers;
	private final int idReservas;

	private UsuarioReservas(
			int idUsuarioReserva,
			int idUsers,
			int idReservas) {

		this.idUsuarioReserva = idUsuarioReserva;
		this.idUsers = idUsers;
		this.idReservas = idReservas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getidUsuarioReserva() {
		return idUsuarioReserva;
	}

	public int getidUsers() {
		return idUsers;
	}

	public int getidReservas() {
		return idReservas;
	}

	@Override
	public String toString() {
		return "UsuarioReservas [idUsuarioReserva=" + idUsuarioReserva +
				", idUsers=" + idUsers +
				", idReservas=" + idReservas + "]";
	}
}
