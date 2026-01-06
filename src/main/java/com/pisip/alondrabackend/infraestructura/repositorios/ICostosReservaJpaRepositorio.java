package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.CostosReservaJpa;

public interface ICostosReservaJpaRepositorio extends JpaRepository<CostosReservaJpa, Integer>{

}
