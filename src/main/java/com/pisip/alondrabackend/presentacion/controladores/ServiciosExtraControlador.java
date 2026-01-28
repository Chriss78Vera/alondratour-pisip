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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IServiciosExtraUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.ServiciosExtraRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.ServiciosExtraResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IServiciosExtraDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/servicios-extra")
public class ServiciosExtraControlador {
	private final IServiciosExtraUseCase serviciosExtraUseCase;
	private final IServiciosExtraDtoMapper serviciosExtraMapperDto;

	public ServiciosExtraControlador(IServiciosExtraUseCase serviciosExtraUseCase, IServiciosExtraDtoMapper serviciosExtraMapperDto) {
		this.serviciosExtraUseCase = serviciosExtraUseCase;
		this.serviciosExtraMapperDto = serviciosExtraMapperDto;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ServiciosExtraResponseDto> listar() {
		return serviciosExtraUseCase.listarTodo().stream().map(serviciosExtraMapperDto::toResponse).toList();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiciosExtraResponseDto crear(@Valid @RequestBody ServiciosExtraRequestDto serviciosExtra) {
		return serviciosExtraMapperDto.toResponse(serviciosExtraUseCase.guardar(serviciosExtraMapperDto.toDomain(serviciosExtra)));
	}

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public ServiciosExtraResponseDto buscarPorId(@RequestParam int id) {
		return serviciosExtraMapperDto.toResponse(serviciosExtraUseCase.buscarPorId(id));
	}

	@GetMapping("/buscarPorIdReserva")
	@ResponseStatus(HttpStatus.OK)
	public List<ServiciosExtraResponseDto> serviciosExtraPorIdReserva(@RequestParam int idReserva) {
		return serviciosExtraUseCase.serviciosExtraPorIdReserva(idReserva).stream().map(serviciosExtraMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorTipoServicio")
	@ResponseStatus(HttpStatus.OK)
	public List<ServiciosExtraResponseDto> serviciosExtraPorTipoServicio(@RequestParam String tipoServicio) {
		return serviciosExtraUseCase.serviciosExtraPorTipoServicio(tipoServicio).stream().map(serviciosExtraMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorRangoFechas")
	@ResponseStatus(HttpStatus.OK)
	public List<ServiciosExtraResponseDto> serviciosExtraPorRangoFechas(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
		return serviciosExtraUseCase.serviciosExtraPorRangoFechas(inicio, fin).stream().map(serviciosExtraMapperDto::toResponse).toList();
	}
}
