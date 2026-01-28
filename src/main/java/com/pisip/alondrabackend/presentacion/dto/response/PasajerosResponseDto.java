package com.pisip.alondrabackend.presentacion.dto.response;

import java.time.LocalDate;

public class PasajerosResponseDto {
	
	private int idPasajero;
	private int idReserva;
	private String nombre;
	private String apellido;
	private String cedula;
	private LocalDate fechaNacimiento;
	private boolean pasaporte;
	private boolean visa;
	
	
	public int getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public boolean isPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(boolean pasaporte) {
		this.pasaporte = pasaporte;
	}
	public boolean isVisa() {
		return visa;
	}
	public void setVisa(boolean visa) {
		this.visa = visa;
	}
	

}
