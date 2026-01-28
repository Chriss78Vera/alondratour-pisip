package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Hoteles;

public interface IHotelesUseCase {
	Hoteles guardar(Hoteles hoteles);

	Hoteles buscarPorId(int id);

	List<Hoteles> listarTodo();

	void eliminar(int id);

	List<Hoteles> hotelesPorNombre(String nombre);

	List<Hoteles> hotelesPorIdPaquetesDetalles(int idPaquetesDetalles);
}
