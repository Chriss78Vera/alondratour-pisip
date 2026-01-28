package com.pisip.alondrabackend.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesDetallesJpa;

public interface IPaquetesDetallesJpaRepositorio extends JpaRepository<PaquetesDetallesJpa, Integer> {

	List<PaquetesDetallesJpa> findByHotel(String hotel);

	@Query("SELECT p FROM PaquetesDetallesJpa p WHERE p.fechaInicio BETWEEN ?1 AND ?2 OR p.fechaFin BETWEEN ?1 AND ?2")
	List<PaquetesDetallesJpa> findByRangoFechas(LocalDate inicio, LocalDate fin);
}
