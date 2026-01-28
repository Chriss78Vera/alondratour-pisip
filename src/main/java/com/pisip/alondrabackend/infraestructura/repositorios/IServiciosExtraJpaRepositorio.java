package com.pisip.alondrabackend.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ServiciosExtraJpa;

public interface IServiciosExtraJpaRepositorio extends JpaRepository<ServiciosExtraJpa, Integer> {

	@Query("SELECT s FROM ServiciosExtraJpa s WHERE s.reserva.idReserva = ?1")
	List<ServiciosExtraJpa> findByIdReserva(int idReserva);

	List<ServiciosExtraJpa> findByTipoServicio(String tipoServicio);

	@Query("SELECT s FROM ServiciosExtraJpa s WHERE s.fechaInicio BETWEEN ?1 AND ?2 OR s.fechaFin BETWEEN ?1 AND ?2")
	List<ServiciosExtraJpa> findByRangoFechas(LocalDate inicio, LocalDate fin);
}
