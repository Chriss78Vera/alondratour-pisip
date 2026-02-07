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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaisesUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.PaisesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaisesResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IPaisesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/paises")
public class PaisesControlador {
	private final IPaisesUseCase paisesUseCase;
	private final IPaisesDtoMapper paisesMapperDto;

	public PaisesControlador(IPaisesUseCase paisesUseCase, IPaisesDtoMapper paisesMapperDto) {
		this.paisesUseCase = paisesUseCase;
		this.paisesMapperDto = paisesMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PaisesResponseDto> listar() {
		return paisesUseCase.listarTodo().stream().map(paisesMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PaisesResponseDto crear(@Valid @RequestBody PaisesRequestDto dto) {
		return paisesMapperDto.toResponse(paisesUseCase.guardar(paisesMapperDto.toDomain(dto)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public PaisesResponseDto buscarPorId(@RequestParam int id) {
		return paisesMapperDto.toResponse(paisesUseCase.buscarPorId(id));
	}
}
