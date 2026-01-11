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
@Table(name = "tb_paquete")
public class PaquetesJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paquetes")
	private int idPaquetes;

	@Column(name = "id_paquetes_detalles", nullable = false)
	private int idPaquetesDetalles;

	@Column(nullable = false)
	private String pais;

	@Column(nullable = false)
	private String ciudad;
	
}