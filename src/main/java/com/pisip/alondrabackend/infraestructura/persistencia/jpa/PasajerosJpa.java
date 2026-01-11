package com.pisip.alondrabackend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_pasajero")
public class PasajerosJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pasajero")
	private int idPasajero;

	@Column(name = "id_reserva", nullable = false)
	private int idReserva;

	@Column(nullable = false)
	private String nombre;

	
	@Column(nullable = false)
	private String apellido;

	
	@Column(nullable = false, unique = true)
	private String cedula;

	
	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate fechaNacimiento;

	
	@Column(nullable = false)
	private boolean pasaporte;

	
	@Column(nullable = false)
	private boolean visa;


}
