package com.pisip.alondrabackend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IAgenciasUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IReservasUseCase;
import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IVuelosUseCase;
import com.pisip.alondrabackend.dominio.entidades.Reservas;
import com.pisip.alondrabackend.presentacion.dto.request.ReservasRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.ReservasResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IReservasDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/reservas")
public class ReservasControlador {

	private final IReservasUseCase reservasUseCase;
	private final IAgenciasUseCase agenciasUseCase;
	private final IPaquetesUseCase paquetesUseCase;
	private final IVuelosUseCase vuelosUseCase;
	private final IReservasDtoMapper mapper;

	public ReservasControlador(IReservasUseCase reservasUseCase, IAgenciasUseCase agenciasUseCase,
			IPaquetesUseCase paquetesUseCase, IVuelosUseCase vuelosUseCase, IReservasDtoMapper mapper) {
		this.reservasUseCase = reservasUseCase;
		this.agenciasUseCase = agenciasUseCase;
		this.paquetesUseCase = paquetesUseCase;
		this.vuelosUseCase = vuelosUseCase;
		this.mapper = mapper;
	}

	@GetMapping
	public List<ReservasResponseDto> listar() {
		return reservasUseCase.listar().stream()
				.map(r -> mapper.toResponseDto(r,
						agenciasUseCase.buscarPorId(r.getIdAgencia()),
						paquetesUseCase.buscarPorId(r.getIdPaquete()),
						vuelosUseCase.buscarPorId(r.getIdVuelo())))
				.toList();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReservasResponseDto crear(@Valid @RequestBody ReservasRequestDto request) {
		Reservas reserva = reservasUseCase.crear(mapper.toDomain(request));
		return mapper.toResponseDto(
				reserva,
				agenciasUseCase.buscarPorId(reserva.getIdAgencia()),
				paquetesUseCase.buscarPorId(reserva.getIdPaquete()),
				vuelosUseCase.buscarPorId(reserva.getIdVuelo()));
	}
}
