package com.pisip.alondrabackend.presentacion.controladores;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPasajerosUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.PasajerosRequestDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IPasajerosDtoMapper;

import jakarta.validation.Valid;



@RestController
@RequestMapping("api/pasajeros")
public class PasajerosControlador {
	

	private final IPasajerosUseCase pasajerosUseCase;
	private final IPasajerosDtoMapper mapper;
	
	
	public PasajerosControlador(IPasajerosUseCase pasajerosUseCase, IPasajerosDtoMapper mapper) {
		this.pasajerosUseCase = pasajerosUseCase;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<PasajerosRequestDto> listar() {
		return pasajerosUseCase.listar().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/buscarPorIdReserva")
	public List<PasajerosRequestDto> listarPorIdReserva(@RequestParam int idReserva) {
		return pasajerosUseCase.listarPorIdReserva(idReserva).stream().map(mapper::toResponseDto).toList();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public PasajerosRequestDto crear(@Valid @RequestBody PasajerosRequestDto request) {
		return mapper.toResponseDto(pasajerosUseCase.crear(mapper.toDomain(request)));
	}

}
