package com.pisip.alondrabackend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IVuelosUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.VuelosRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.VuelosResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IVuelosDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/vuelos")
public class VuelosControlador {
	private final IVuelosUseCase vuelosUseCase;
	private final IVuelosDtoMapper vuelosMapperDto;
	
	
	public VuelosControlador(IVuelosUseCase vuelosUseCase, IVuelosDtoMapper vuelosMapperDto) {
		super();
		this.vuelosUseCase = vuelosUseCase;
		this.vuelosMapperDto = vuelosMapperDto;
	}

	@GetMapping
	public List<VuelosResponseDto> listar(){
		return vuelosUseCase.listarTodo().stream().map(vuelosMapperDto::toResponse).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VuelosResponseDto crear(@Valid @RequestBody VuelosRequestDto vuelos) {
		return vuelosMapperDto.toResponse(vuelosUseCase.guardar(vuelosMapperDto.toDomain(vuelos)));
	}
}
