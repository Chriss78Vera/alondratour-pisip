package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.HotelesReservas;

public interface IHotelesReservasRepositorio {
	HotelesReservas guardar(HotelesReservas hotelesReservas);

	Optional<HotelesReservas> buscarPorId(int id);

	List<HotelesReservas> listarTodo();

	void eliminar(int id);

	List<HotelesReservas> hotelesReservasPorIdReserva(int idReserva);

	List<HotelesReservas> hotelesReservasPorIdHotel(int idHotel);
}
