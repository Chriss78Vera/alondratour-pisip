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
@Table(name = "reserva_detalles")
public class FechadeVueloJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fecha_vuelo")
	private int idFechadeVuelo;

	@Column(name = "id_fecha_vuelo", nullable = false)
	private int idFechadeVuelo1;

	@Column(name = "id_vuelo", nullable = false)
	private int idVuelo;

	@Column(name = "id_servicios_extras", nullable = false)
	private int idServiciosExtras;

	@Column(name = "id_paquetes", nullable = false)
	private int idPaquetes;

	@Column(name = "id_agencia", nullable = false)
	private int idAgencia;

	@Column(name = "id_pasajero", nullable = false)
	private int idPasajero;


}
