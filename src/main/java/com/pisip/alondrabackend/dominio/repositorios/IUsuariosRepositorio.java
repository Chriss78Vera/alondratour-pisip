package com.pisip.alondrabackend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.Usuarios;

public interface IUsuariosRepositorio {
	Usuarios guardar(Usuarios usuarios);

	Optional<Usuarios> buscarPorId(int id);

	List<Usuarios> listarTodo();

	void eliminar(int id);

	Optional<Usuarios> buscarPorCedula(String cedula);

	Optional<Usuarios> buscarPorCorreo(String correo);

	List<Usuarios> listarPorRol(String rol);
}
