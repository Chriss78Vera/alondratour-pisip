package com.pisip.alondrabackend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_hotel")
public class HotelesJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hotel")
	private int idHotel;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String ciudad;

	@Column(nullable = false)
	private String pais;

	@Column(name = "fecha_checkin", nullable = false)
	private LocalDate fechaCheckin;

	@Column(name = "fecha_checkout", nullable = false)
	private LocalDate fechaCheckout;

	@Column(name = "fecha_extra_checkin")
	private LocalDate fechaExtraCheckin;

	@Column(name = "fecha_extra_checkout")
	private LocalDate fechaExtraCheckout;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ReservasJpa> reservas;

}