package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;


import com.pisip.alondrabackend.dominio.entidades.Vuelos;

public interface IVuelosUseCase {
	Vuelos guardar(Vuelos vuelos);
	
	Vuelos buscarPorId(int id);
	
	List<Vuelos> listarTodo();
	
	void eliminar(int id);
}
