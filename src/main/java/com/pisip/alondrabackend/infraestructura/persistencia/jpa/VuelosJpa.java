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
@Table(name = "tb_vuelo")
public class VuelosJpa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vuelo")
	private int idVuelo;

	
	@Column(nullable = false)
	private String aerolinea;

	
	@Column(nullable = false)
	private String origen;

	
	@Column(nullable = false)
	private String destino;

	
	@Column(name = "fecha_salida", nullable = false)
	private LocalDate fechaSalida;

	
	@Column(name = "fecha_llegada", nullable = false)
	private LocalDate fechaLlegada;

	@Column(name = "fecha_extra_salida")
	private LocalDate fechaExtraSalida;

	@Column(name = "fecha_extra_llegada")
	private LocalDate fechaExtraLlegada;
}
