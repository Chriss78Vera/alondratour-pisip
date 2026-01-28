package com.pisip.alondrabackend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_hotel_reserva")
public class HotelesReservasJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hotel_reserva")
	private int idHotelReserva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_reserva", nullable = false)
	private ReservasJpa reserva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hotel", nullable = false)
	private HotelesJpa hotel;

	@Column(name = "fecha_checkin", nullable = false)
	private LocalDate fechaCheckin;

	@Column(name = "fecha_checkout", nullable = false)
	private LocalDate fechaCheckout;

	@Column(name = "fecha_extra_checkin")
	private LocalDate fechaExtraCheckin;

	@Column(name = "fecha_extra_checkout")
	private LocalDate fechaExtraCheckout;
}
