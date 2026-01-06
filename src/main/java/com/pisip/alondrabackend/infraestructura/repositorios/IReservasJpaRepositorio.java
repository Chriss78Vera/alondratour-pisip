package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ReservasJpa;

public interface IReservasJpaRepositorio  extends JpaRepository<ReservasJpa, Integer> {

}
