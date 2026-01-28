package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.HotelesReservas;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.HotelesReservasJpa;

@Mapper(componentModel = "spring")
public interface IHotelesReservasJpaMapper {

	@Mapping(source = "reserva.idReserva", target = "idReserva")
	@Mapping(source = "hotel.idHotel", target = "idHotel")
	HotelesReservas toDomain(HotelesReservasJpa entity);

	@Mapping(target = "reserva", ignore = true)
	@Mapping(target = "hotel", ignore = true)
	HotelesReservasJpa toEntity(HotelesReservas hotelesReservas);
}
