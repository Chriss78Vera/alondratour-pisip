package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Agencias;

public interface IAgenciasUseCase {
	Agencias guardar(Agencias agencias);

	Agencias buscarPorId(int id);

	List<Agencias> listarTodo();

	void eliminar(int id);

	List<Agencias> agenciasPorNombre(String nombre);
}
