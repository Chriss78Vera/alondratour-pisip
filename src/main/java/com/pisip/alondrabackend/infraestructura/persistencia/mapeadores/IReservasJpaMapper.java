package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ReservasJpa;

@Mapper(componentModel = "spring")
public interface IReservasJpaMapper {
	
	Reservas toDomain(ReservasJpa entity);

	ReservasJpa toEntity(Reservas reservas);

}
