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
@Table(name = "tb_reserva")
public class ReservasJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idReserva;

	
	@Column(name = "id_usuario", nullable = false)
	private int idUsuario;

	
	@Column(name = "id_hotel", nullable = false)
	private int idHotel;

	
	@Column(name = "id_vuelo", nullable = false)
	private int idVuelo;

	
	@Column(name = "id_paquete", nullable = false)
	private int idPaquete;

	
	@Column(name = "id_agencia", nullable = false)
	private int idAgencia;

	
	@Column(name = "fecha_reserva", nullable = false)
	private LocalDate fechaReserva;

	
	@Column(name = "costo_total", nullable = false)
	private float costoTotal;

	
	@Column(nullable = false)
	private boolean estado;

}
