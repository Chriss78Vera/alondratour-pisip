package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.HotelesReservas;

public interface IHotelesReservasUseCase {
	HotelesReservas guardar(HotelesReservas hotelesReservas);

	HotelesReservas buscarPorId(int id);

	List<HotelesReservas> listarTodo();

	void eliminar(int id);

	List<HotelesReservas> hotelesReservasPorIdReserva(int idReserva);

	List<HotelesReservas> hotelesReservasPorIdHotel(int idHotel);
}
