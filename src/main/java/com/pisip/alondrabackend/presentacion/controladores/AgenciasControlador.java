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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IAgenciasUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.AgenciasRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.AgenciasResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IAgenciasDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/agencias")
public class AgenciasControlador {
	private final IAgenciasUseCase agenciasUseCase;
	private final IAgenciasDtoMapper agenciasMapperDto;

	public AgenciasControlador(IAgenciasUseCase agenciasUseCase, IAgenciasDtoMapper agenciasMapperDto) {
		this.agenciasUseCase = agenciasUseCase;
		this.agenciasMapperDto = agenciasMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<AgenciasResponseDto> listar() {
		return agenciasUseCase.listarTodo().stream().map(agenciasMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AgenciasResponseDto crear(@Valid @RequestBody AgenciasRequestDto agencias) {
		return agenciasMapperDto.toResponse(agenciasUseCase.guardar(agenciasMapperDto.toDomain(agencias)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public AgenciasResponseDto buscarPorId(@RequestParam int id) {
		return agenciasMapperDto.toResponse(agenciasUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorNombre")
	@ResponseStatus(HttpStatus.OK)
	public List<AgenciasResponseDto> agenciasPorNombre(@RequestParam String nombre) {
		return agenciasUseCase.agenciasPorNombre(nombre).stream().map(agenciasMapperDto::toResponse).toList();
	}
}
