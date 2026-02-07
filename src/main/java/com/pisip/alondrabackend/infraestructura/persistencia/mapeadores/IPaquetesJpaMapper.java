package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.PaquetesJpa;

public interface IPaquetesJpaMapper {

	Paquetes toDomain(PaquetesJpa entity);

	PaquetesJpa toEntity(Paquetes paquetes);
}
