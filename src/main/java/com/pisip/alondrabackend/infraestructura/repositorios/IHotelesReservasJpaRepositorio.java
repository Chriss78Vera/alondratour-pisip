package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesReservasJpa;

public interface IHotelesReservasJpaRepositorio extends JpaRepository<HotelesReservasJpa, Integer> {

	@Query("SELECT hr FROM HotelesReservasJpa hr WHERE hr.reserva.idReserva = ?1")
	List<HotelesReservasJpa> findByIdReserva(int idReserva);

	@Query("SELECT hr FROM HotelesReservasJpa hr WHERE hr.hotel.idHotel = ?1")
	List<HotelesReservasJpa> findByIdHotel(int idHotel);
}
