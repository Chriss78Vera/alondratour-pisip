package com.pisip.alondrabackend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.infraestructura.persistencia.jpa.ReservasJpa;

@Mapper(componentModel = "spring")
public interface IReservasJpaMapper {

	@Mapping(source = "usuario.idUsuario", target = "idUsuario")
	@Mapping(source = "vuelo.idVuelo", target = "idVuelo")
	@Mapping(source = "paquete.idPaquetes", target = "idPaquete")
	@Mapping(source = "agencia.idAgencia", target = "idAgencia")
	Reservas toDomain(ReservasJpa entity);

	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "vuelo", ignore = true)
	@Mapping(target = "paquete", ignore = true)
	@Mapping(target = "agencia", ignore = true)
	@Mapping(target = "pasajeros", ignore = true)
	@Mapping(target = "serviciosExtra", ignore = true)
	ReservasJpa toEntity(Reservas reservas);

}
