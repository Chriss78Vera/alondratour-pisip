package com.pisip.alondrabackend.infraestructura.persistencia.jpa;


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
@Table(name = "vuelos_detalles")
public class VuelosDetallesJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vuelos_detalle")
	private int idvuelosDetalle;

	@Column(name = "id_vuelos", nullable = false)
	private int idvuelos;

	@Column(name = "id_pasajero", nullable = false)
	private String idPasajero;
}
