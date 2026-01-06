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
@Table(name = "tb_costo_paquete")
public class CostoPaqueteJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_costo_paquete")
	private int idCostoPaquete;

	@Column(name = "id_paquetes", nullable = false)
	private int idPaquetes;

	@Column(name = "id_costos", nullable = false)
	private int idCostos;
}