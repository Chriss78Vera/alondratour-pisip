package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ReservaDetallesJpa;

public interface IReservaDetallesJpaRepositorio  extends JpaRepository<ReservaDetallesJpa, Integer> {

}
