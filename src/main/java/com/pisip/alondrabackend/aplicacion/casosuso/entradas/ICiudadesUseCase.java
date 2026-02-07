package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Ciudades;

public interface ICiudadesUseCase {
	Ciudades guardar(Ciudades ciudades);

	Ciudades buscarPorId(int id);

	List<Ciudades> listarTodo();

	void eliminar(int id);

	List<Ciudades> buscarPorIdPais(int idPais);
}
