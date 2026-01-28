package com.pisip.alondrabackend.infraestructura.persistencia.jpa;

import java.io.Serializable;
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
@Table(name = "tb_paquete")
public class PaquetesJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paquetes")
	private int idPaquetes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paquetes_detalles", nullable = false)
	private PaquetesDetallesJpa paquetesDetalles;

	@Column(nullable = false)
	private String nombre;

	@Column(length = 2000)
	private String descripcion;

	@Column(nullable = false)
	private String pais;

	@Column(nullable = false)
	private String ciudad;

	@OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ReservasJpa> reservas;

}