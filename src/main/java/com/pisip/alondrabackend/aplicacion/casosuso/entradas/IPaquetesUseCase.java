package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;

public interface IPaquetesUseCase {
	Paquetes guardar(Paquetes paquetes);

	Paquetes buscarPorId(int id);

	List<Paquetes> listarTodo();

	void eliminar(int id);

	List<Paquetes> paquetesPorPais(String pais);

	List<Paquetes> paquetesPorCiudad(String ciudad);

	List<Paquetes> paquetesPorPaisYCiudad(String pais, String ciudad);

	List<Paquetes> paquetesPorIdPaquetesDetalles(int idPaquetesDetalles);

	List<String> paisesDistintos();

	List<String> ciudadesDistintas();
}
