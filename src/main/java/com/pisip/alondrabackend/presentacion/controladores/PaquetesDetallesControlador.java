package com.pisip.alondrabackend.presentacion.controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IPaquetesDetallesUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.PaquetesDetallesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.PaquetesDetallesResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IPaquetesDetallesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/paquetes-detalles")
public class PaquetesDetallesControlador {
	private final IPaquetesDetallesUseCase paquetesDetallesUseCase;
	private final IPaquetesDetallesDtoMapper paquetesDetallesMapperDto;

	public PaquetesDetallesControlador(IPaquetesDetallesUseCase paquetesDetallesUseCase, IPaquetesDetallesDtoMapper paquetesDetallesMapperDto) {
		this.paquetesDetallesUseCase = paquetesDetallesUseCase;
		this.paquetesDetallesMapperDto = paquetesDetallesMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PaquetesDetallesResponseDto> listar() {
		return paquetesDetallesUseCase.listarTodo().stream().map(paquetesDetallesMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PaquetesDetallesResponseDto crear(@Valid @RequestBody PaquetesDetallesRequestDto paquetesDetalles) {
		return paquetesDetallesMapperDto.toResponse(paquetesDetallesUseCase.guardar(paquetesDetallesMapperDto.toDomain(paquetesDetalles)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public PaquetesDetallesResponseDto buscarPorId(@RequestParam int id) {
		return paquetesDetallesMapperDto.toResponse(paquetesDetallesUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorRangoFechas")
	@ResponseStatus(HttpStatus.OK)
	public List<PaquetesDetallesResponseDto> paquetesDetallesPorRangoFechas(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
		return paquetesDetallesUseCase.paquetesDetallesPorRangoFechas(inicio, fin).stream().map(paquetesDetallesMapperDto::toResponse).toList();
	}
}
