package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;

public interface IPaquetesJpaRepositorio extends JpaRepository<PaquetesJpa, Integer> {

	@Query("SELECT p FROM PaquetesJpa p WHERE p.pais = ?1")
	List<PaquetesJpa> paquetesPorPais(String pais);

	@Query("SELECT p FROM PaquetesJpa p WHERE p.ciudad = ?1")
	List<PaquetesJpa> paquetesPorCiudad(String ciudad);

	@Query("SELECT p FROM PaquetesJpa p WHERE p.pais = ?1 AND p.ciudad = ?2")
	List<PaquetesJpa> paquetesPorPaisYCiudad(String pais, String ciudad);

	@Query("SELECT p FROM PaquetesJpa p WHERE p.paquetesDetalles.idPaquetesDetalles = ?1")
	List<PaquetesJpa> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles);
}
