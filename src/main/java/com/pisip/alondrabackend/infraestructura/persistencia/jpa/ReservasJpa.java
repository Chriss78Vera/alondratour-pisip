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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private UsuariosJpa usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vuelo", nullable = false)
	private VuelosJpa vuelo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paquete", nullable = false)
	private PaquetesJpa paquete;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agencia", nullable = false)
	private AgenciasJpa agencia;

	@Column(name = "fecha_reserva", nullable = false)
	private LocalDate fechaReserva;

	@Column(name = "costo_total", nullable = false)
	private float costoTotal;

	@Column(nullable = false)
	private boolean estado;

	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PasajerosJpa> pasajeros;

	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ServiciosExtraJpa> serviciosExtra;

}
