package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.UsuarioReservasJpa;

public interface IUsuarioReservasJpaRepositorio  extends JpaRepository<UsuarioReservasJpa, Integer> {

}
