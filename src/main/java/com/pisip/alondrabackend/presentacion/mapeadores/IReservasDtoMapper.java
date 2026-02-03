package com.pisip.alondrabackend.presentacion.mapeadores;

import com.pisip.alondrabackend.dominio.entidades.Agencias;
import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.presentacion.dto.request.ReservasRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.ReservasResponseDto;

public interface IReservasDtoMapper {

	Reservas toDomain(ReservasRequestDto dto);

	ReservasResponseDto toResponseDto(Reservas reserva, Agencias agencia, Paquetes paquete, Vuelos vuelo);
}
