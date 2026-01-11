package com.pisip.alondrabackend.infraestructura.persistencia.jpa;

import java.time.LocalDate;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_paquetes_detalles")
public class PaquetesDetallesJpa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paquetes_detalles")
	private int idPaquetesDetalles;

	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fechaInicio;

	@Column(name = "fecha_fin", nullable = false)
	private LocalDate fechaFin;

	@Column(nullable = false)
	private String hotel;

	@Column(name = "precio_neto", nullable = false)
	private float precioNeto;
	
}
