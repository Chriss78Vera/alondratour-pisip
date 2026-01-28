package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;

public interface IHotelesJpaRepositorio extends JpaRepository<HotelesJpa, Integer> {

	@Query("SELECT h FROM HotelesJpa h WHERE h.nombre = ?1")
	List<HotelesJpa> hotelesPorNombre(String nombre);

	@Query("SELECT h FROM HotelesJpa h WHERE h.paquetesDetalles.idPaquetesDetalles = ?1")
	List<HotelesJpa> findByPaquetesDetallesIdPaquetesDetalles(int idPaquetesDetalles);
}
