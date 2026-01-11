package com.pisip.alondrabackend.dominio.entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Pasajeros implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int idPasajero;
	private final int idReserva;
	private final String nombre;
	private final String apellido;
	private final String cedula;
	private final LocalDate fechaNacimiento;
	private final boolean pasaporte;
	private final boolean visa;
	
	public Pasajeros(int idPasajero, int idReserva, String nombre, String apellido, String cedula,
			LocalDate fechaNacimiento, boolean pasaporte, boolean visa) {
		super();
		this.idPasajero = idPasajero;
		this.idReserva = idReserva;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.fechaNacimiento = fechaNacimiento;
		this.pasaporte = pasaporte;
		this.visa = visa;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdPasajero() {
		return idPasajero;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public boolean isPasaporte() {
		return pasaporte;
	}
	public boolean isVisa() {
		return visa;
	}
	@Override
	public String toString() {
		return "Pasajeros [idPasajero=" + idPasajero + ", idReserva=" + idReserva + ", nombre=" + nombre + ", apellido="
				+ apellido + ", cedula=" + cedula + ", fechaNacimiento=" + fechaNacimiento + ", pasaporte=" + pasaporte
				+ ", visa=" + visa + "]";
	}
	
	
}
