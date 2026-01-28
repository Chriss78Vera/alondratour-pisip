package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuariosJpa;

public interface IUsuariosJpaRepositorio extends JpaRepository<UsuariosJpa, Integer> {

	Optional<UsuariosJpa> findByCedula(String cedula);

	Optional<UsuariosJpa> findByCorreo(String correo);

	List<UsuariosJpa> findByRol(String rol);
}
