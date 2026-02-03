package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PasajerosJpa;

public interface IPasajerosJpaRepositorio extends JpaRepository<PasajerosJpa, Integer> {

	@Query("SELECT p FROM PasajerosJpa p WHERE p.reserva.idReserva = ?1")
	List<PasajerosJpa> findByReservaIdReserva(int idReserva);
}
