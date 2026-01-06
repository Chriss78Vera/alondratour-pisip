package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuariosJpa;

public interface IUsuariosJpaRepositorio  extends JpaRepository<UsuariosJpa, Integer> {

}
