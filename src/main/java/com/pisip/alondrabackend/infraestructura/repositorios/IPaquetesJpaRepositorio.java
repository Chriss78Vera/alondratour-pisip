package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;

public interface IPaquetesJpaRepositorio extends JpaRepository<PaquetesJpa, Integer> {

	List<PaquetesJpa> findByPais_IdPais(int idPais);

	List<PaquetesJpa> findByCiudad_IdCiudad(int idCiudad);

	@Query("SELECT p FROM PaquetesJpa p WHERE p.pais.idPais = ?1 AND p.ciudad.idCiudad = ?2")
	List<PaquetesJpa> paquetesPorIdPaisYIdCiudad(int idPais, int idCiudad);

	@Query("SELECT p FROM PaquetesJpa p WHERE p.paquetesDetalles.idPaquetesDetalles = ?1")
	List<PaquetesJpa> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles);

	@Query("SELECT DISTINCT p.pais.nombre FROM PaquetesJpa p ORDER BY p.pais.nombre")
	List<String> findDistinctPaisNombre();

	@Query("SELECT DISTINCT p.ciudad.nombre FROM PaquetesJpa p ORDER BY p.ciudad.nombre")
	List<String> findDistinctCiudadNombre();
}
