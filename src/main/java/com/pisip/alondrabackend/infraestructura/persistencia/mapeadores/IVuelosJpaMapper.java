package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.VuelosJpa;

public interface IVuelosJpaMapper {

	Vuelos toDomain(VuelosJpa entity);

	VuelosJpa toEntity(Vuelos vuelos);
}
