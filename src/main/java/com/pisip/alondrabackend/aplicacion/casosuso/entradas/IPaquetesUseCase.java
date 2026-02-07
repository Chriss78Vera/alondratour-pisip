package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;

public interface IPaquetesUseCase {
	Paquetes guardar(Paquetes paquetes);

	Paquetes buscarPorId(int id);

	List<Paquetes> listarTodo();

	void eliminar(int id);

	List<Paquetes> paquetesPorIdPais(int idPais);

	List<Paquetes> paquetesPorIdCiudad(int idCiudad);

	List<Paquetes> paquetesPorIdPaisYIdCiudad(int idPais, int idCiudad);

	List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles);

	List<String> paisesDistintos();

	List<String> ciudadesDistintas();
}
