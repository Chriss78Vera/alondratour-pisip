package com.pisip.alondrabackend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IReservasUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.ReservasRequestDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IReservasDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/reservas")
public class ReservasControlador {
	
	private final IReservasUseCase reservasUseCase;
	private final IReservasDtoMapper mapper;
	
	

	
	public ReservasControlador(IReservasUseCase reservasUseCase, IReservasDtoMapper mapper) {
		super();
		this.reservasUseCase = reservasUseCase;
		this.mapper = mapper;
	}




	@GetMapping
	public List<ReservasRequestDto> listar (){
		return reservasUseCase.listar().stream().map(mapper :: toResponseDto).toList();	
		
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReservasRequestDto crear(@Valid @RequestBody ReservasRequestDto request) {
		return mapper.toResponseDto(reservasUseCase.crear(mapper.toDomain(request)));
	}


}
