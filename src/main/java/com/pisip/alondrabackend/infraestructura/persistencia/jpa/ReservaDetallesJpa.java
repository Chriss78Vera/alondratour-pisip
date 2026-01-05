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
public class ReservaDetallesJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva_detalle")
	private int idReservaDetalle;

	@Column(name = "id_reserva", nullable = false)
	private int idReserva;

	@Column(name = "id_hotel", nullable = false)
	private int idHotel;

	@Column(name = "id_servicios_extras", nullable = false)
	private int idServiciosExtras;

	@Column(name = "id_paquetes", nullable = false)
	private int idPaquetes;

	@Column(name = "id_agencia", nullable = false)
	private int idAgencia;

	@Column(name = "id_pasajero", nullable = false)
	private int idPasajero;

	@Column(name = "id_vuelos", nullable = false)
	private int idVuelos;

}
