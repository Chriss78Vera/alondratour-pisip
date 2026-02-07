package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Paises;

public interface IPaisesUseCase {
	Paises guardar(Paises paises);

	Paises buscarPorId(int id);

	List<Paises> listarTodo();

	void eliminar(int id);
}
