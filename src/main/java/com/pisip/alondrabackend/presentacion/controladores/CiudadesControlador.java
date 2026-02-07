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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.ICiudadesUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.CiudadesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.CiudadesResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.ICiudadesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ciudades")
public class CiudadesControlador {
	private final ICiudadesUseCase ciudadesUseCase;
	private final ICiudadesDtoMapper ciudadesMapperDto;

	public CiudadesControlador(ICiudadesUseCase ciudadesUseCase, ICiudadesDtoMapper ciudadesMapperDto) {
		this.ciudadesUseCase = ciudadesUseCase;
		this.ciudadesMapperDto = ciudadesMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CiudadesResponseDto> listar() {
		return ciudadesUseCase.listarTodo().stream().map(ciudadesMapperDto::toResponse).toList();
	}

	@GetMapping("/porPais")
	@ResponseStatus(HttpStatus.OK)
	public List<CiudadesResponseDto> listarPorIdPais(@RequestParam int idPais) {
		return ciudadesUseCase.buscarPorIdPais(idPais).stream().map(ciudadesMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CiudadesResponseDto crear(@Valid @RequestBody CiudadesRequestDto dto) {
		return ciudadesMapperDto.toResponse(ciudadesUseCase.guardar(ciudadesMapperDto.toDomain(dto)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public CiudadesResponseDto buscarPorId(@RequestParam int id) {
		return ciudadesMapperDto.toResponse(ciudadesUseCase.buscarPorId(id));
	}
}
