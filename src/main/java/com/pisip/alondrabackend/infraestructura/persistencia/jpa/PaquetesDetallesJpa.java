package com.pisip.alondrabackend.infraestructura.persistencia.jpa;

import java.time.LocalDate;
import java.io.Serializable;
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

	@Column(name = "precio_neto", nullable = false)
	private float precioNeto;

	@OneToMany(mappedBy = "paquetesDetalles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PaquetesJpa> paquetes;

	@OneToMany(mappedBy = "paquetesDetalles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HotelesJpa> hoteles;

}
