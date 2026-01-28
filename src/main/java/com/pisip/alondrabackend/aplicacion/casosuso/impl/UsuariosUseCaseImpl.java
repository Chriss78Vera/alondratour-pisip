package com.pisip.alondrabackend.aplicacion.casosuso.impl;

import java.util.List;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IUsuariosUseCase;
import com.pisip.alondrabackend.dominio.entidades.Usuarios;
import com.pisip.alondrabackend.dominio.repositorios.IUsuariosRepositorio;

public class UsuariosUseCaseImpl implements IUsuariosUseCase {

	private final IUsuariosRepositorio repositorio;

	public UsuariosUseCaseImpl(IUsuariosRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Usuarios guardar(Usuarios usuarios) {
		return repositorio.guardar(usuarios);
	}

	@Override
	public Usuarios buscarPorId(int id) {
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public List<Usuarios> listarTodo() {
		return repositorio.listarTodo();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

	@Override
	public Usuarios buscarPorCedula(String cedula) {
		return repositorio.buscarPorCedula(cedula).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public Usuarios buscarPorCorreo(String correo) {
		return repositorio.buscarPorCorreo(correo).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public List<Usuarios> listarPorRol(String rol) {
		return repositorio.listarPorRol(rol);
	}
}
