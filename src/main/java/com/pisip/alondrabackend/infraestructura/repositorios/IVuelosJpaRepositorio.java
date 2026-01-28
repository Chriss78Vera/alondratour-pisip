package com.pisip.alondrabackend.infraestructura.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;

public interface IVuelosJpaRepositorio extends JpaRepository<VuelosJpa, Integer> {

    /*
     * Vuelos por aerolínea
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.aerolinea = ?1")
    public List<VuelosJpa> listarPorAerolinea(String aerolinea);

    /*
     * Próximos vuelos (desde hoy)
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaSalida >= CURRENT_DATE")
    public List<VuelosJpa> proximosVuelos();

    /*
     * Vuelos por origen
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.origen = ?1")
    public List<VuelosJpa> listarPorOrigen(String origen);

    /*
     * Vuelos por destino
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.destino = ?1")
    public List<VuelosJpa> listarPorDestino(String destino);

    /*
     * Vuelos por fecha de salida
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaSalida = ?1")
    public List<VuelosJpa> listarPorFechaDeSalida(LocalDate fecha);

    /*
     * Vuelos por fecha de llegada
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaLlegada = ?1")
    public List<VuelosJpa> listarPorFechaDeLlegada(LocalDate fecha);

    /*
     * Vuelos por rango de fechas de salida
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaSalida BETWEEN ?1 AND ?2")
    public List<VuelosJpa> listarPorRangoDeFechas(LocalDate fechaInicial, LocalDate fechaFinal);

    /*
     * Vuelos con fecha extra de salida
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaExtraSalida IS NOT NULL")
    public List<VuelosJpa> vuelosConFechaExtraSalida();

    /*
     * Vuelos por fecha extra de salida
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaExtraSalida = ?1")
    public List<VuelosJpa> listarPorFechaExtraDeSalida(LocalDate fecha);

    /*
     * Vuelos por fecha extra de llegada
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaExtraLlegada = ?1")
    public List<VuelosJpa> listarPorFechaExtraDeLlegada(LocalDate fecha);

    /*
     * Vuelos por rango de fechas extra de salida
     */
    @Query("SELECT v FROM VuelosJpa v WHERE v.fechaExtraSalida BETWEEN ?1 AND ?2")
    public List<VuelosJpa> listarPorRangoDeFechasExtras(LocalDate fechaInicial, LocalDate fechaFinal);
}
