package com.pisip.alondrabackend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.alondrabackend.infraestructura.persistencia.jpa.CostoPaqueteJpa;

public interface ICostoPaqueteJpaRepositorio extends JpaRepository<CostoPaqueteJpa, Integer>{

}
