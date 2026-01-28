package com.pisip.alondrabackend.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesJpa;


public interface IHotelesJpaRepositorio extends JpaRepository<HotelesJpa, Integer>{

	@Query("SELECT h FROM HotelesJpa h WHERE h.nombre = ?1")
	public List<HotelesJpa> hotelesPorNombre(String nombre);

	@Query("SELECT h FROM HotelesJpa h WHERE h.paquetesDetalles.idPaquetesDetalles = ?1")
	public List<HotelesJpa> findByPaquetesDetallesIdPaquetesDetalles(int idPaquetesDetalles);

	/*
     * Hoteles por fecha de fecha Checkin
     */
    @Query("SELECT h FROM HotelesJpa h WHERE h.fechaCheckin = ?1")
    public List<HotelesJpa> listarPorFechaDeCheckin(LocalDate fecha);

    /*J
     * Hoteles por fecha de fecha Checkout
     */
    @Query("SELECT h FROM HotelesJpa h WHERE h.fechaCheckout = ?1")
    public List<HotelesJpa> listarPorFechaDeCheckout(LocalDate fecha);

    /*
     * Hoteles por rango de fechas Checking
     */
    @Query("SELECT h FROM HotelesJpa h WHERE h.fechaCheckin BETWEEN ?1 AND ?2")
    public List<HotelesJpa> listarPorRangoDeFechas(LocalDate fechaInicial, LocalDate fechaFinal);

    /*
     * Hoteles con fecha extra de Checkin
     */
    @Query("SELECT h FROM HotelesJpa h WHERE h.fechaExtraCheckin IS NOT NULL")
    public List<HotelesJpa> hotelesConfechaExtraCheckin();

    /*
     * Hoteles por fecha extra de Checkin
     */
    @Query("SELECT h FROM HotelesJpa h WHERE h.fechaExtraCheckin = ?1")
    public List<HotelesJpa> listarPorFechaExtraCheckin(LocalDate fecha);

    /*
     * Hoteles por fecha extra de Checkout
     */
    @Query("SELECT h FROM HotelesJpa h WHERE h.fechaExtraCheckout = ?1")
    public List<HotelesJpa> listarPorFechaExtraCheckout(LocalDate fecha);

    /*
     * Hoteles por rango de fechas extra de salida
     */
    @Query("SELECT h FROM HotelesJpa h WHERE h.fechaExtraCheckin BETWEEN ?1 AND ?2")
    public List<HotelesJpa> listarPorRangoDeFechasExtras(LocalDate fechaInicial, LocalDate fechaFinal);
}
