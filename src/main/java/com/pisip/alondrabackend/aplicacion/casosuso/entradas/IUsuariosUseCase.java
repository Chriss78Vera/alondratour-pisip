package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;

public interface IUsuariosUseCase {
	Usuarios guardar(Usuarios usuarios);

	Usuarios buscarPorId(int id);

	List<Usuarios> listarTodo();

	void eliminar(int id);

	Usuarios buscarPorCedula(String cedula);

	Usuarios buscarPorCorreo(String correo);

	List<Usuarios> listarPorRol(String rol);
}
