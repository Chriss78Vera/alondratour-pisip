package com.pisip.alondrabackend.presentacion.mapeadores;

import org.springframework.stereotype.Component;

import com.pisip.alondrabackend.dominio.entidades.Agencias;
import com.pisip.alondrabackend.dominio.entidades.Paquetes;
import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.dominio.entidades.Vuelos;
import com.pisip.alondrabackend.presentacion.dto.request.ReservasRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.ReservasResponseDto;

@Component
public class ReservasDtoMapperImpl implements IReservasDtoMapper {

	private final IAgenciasDtoMapper agenciasMapper;
	private final IPaquetesDtoMapper paquetesMapper;
	private final IVuelosDtoMapper vuelosMapper;

	public ReservasDtoMapperImpl(IAgenciasDtoMapper agenciasMapper, IPaquetesDtoMapper paquetesMapper,
			IVuelosDtoMapper vuelosMapper) {
		this.agenciasMapper = agenciasMapper;
		this.paquetesMapper = paquetesMapper;
		this.vuelosMapper = vuelosMapper;
	}

	@Override
	public Reservas toDomain(ReservasRequestDto dto) {
		if (dto == null) {
			return null;
		}
		return new Reservas(
				dto.getIdReserva(),
				dto.getIdUsuario(),
				dto.getIdVuelo(),
				dto.getIdPaquete(),
				dto.getIdAgencia(),
				dto.getFechaReserva(),
				dto.getCostoTotal(),
				dto.isEstado());
	}

	@Override
	public ReservasResponseDto toResponseDto(Reservas reserva, Agencias agencia, Paquetes paquete, Vuelos vuelo) {
		if (reserva == null) {
			return null;
		}
		ReservasResponseDto dto = new ReservasResponseDto();
		dto.setIdReserva(reserva.getIdReserva());
		dto.setIdUsuario(reserva.getIdUsuario());
		dto.setFechaReserva(reserva.getFechaReserva());
		dto.setCostoTotal(reserva.getCostoTotal());
		dto.setEstado(reserva.isEstado());
		dto.setAgencia(agencia != null ? agenciasMapper.toResponse(agencia) : null);
		dto.setPaquete(paquete != null ? paquetesMapper.toResponse(paquete) : null);
		dto.setVuelo(vuelo != null ? vuelosMapper.toResponse(vuelo) : null);
		return dto;
	}
}
