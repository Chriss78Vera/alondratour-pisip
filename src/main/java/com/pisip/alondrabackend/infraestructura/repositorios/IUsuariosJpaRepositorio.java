package com.pisip.alondrabackend.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuariosJpa;

public interface IUsuariosJpaRepositorio extends JpaRepository<UsuariosJpa, Integer> {

	Optional<UsuariosJpa> findByCedula(String cedula);

	Optional<UsuariosJpa> findByCorreo(String correo);

	Optional<UsuariosJpa> findByTokenAuth(String tokenAuth);

	List<UsuariosJpa> findByRol_Tipo(String tipo);
}
