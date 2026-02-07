package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Rol;

public interface IRolUseCase {
	Rol guardar(Rol rol);

	Rol buscarPorId(int id);

	List<Rol> listarTodo();

	void eliminar(int id);

	Rol buscarPorTipo(String tipo);
}
