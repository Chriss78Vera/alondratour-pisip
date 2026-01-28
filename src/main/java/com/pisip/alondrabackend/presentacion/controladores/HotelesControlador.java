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

import com.pisip.alondrabackend.aplicacion.casosuso.entradas.IHotelesUseCase;
import com.pisip.alondrabackend.presentacion.dto.request.HotelesRequestDto;
import com.pisip.alondrabackend.presentacion.dto.response.HotelesResponseDto;
import com.pisip.alondrabackend.presentacion.mapeadores.IHotelesDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/hoteles")
public class HotelesControlador {
	private final IHotelesUseCase hotelesUseCase;
	private final IHotelesDtoMapper hotelesMapperDto;
	
	public HotelesControlador(IHotelesUseCase hotelesUseCase, IHotelesDtoMapper hotelesMapperDto) {
		super();
		this.hotelesUseCase = hotelesUseCase;
		this.hotelesMapperDto = hotelesMapperDto;
	}
	
	@GetMapping
	public List<HotelesResponseDto> listar(){
		return hotelesUseCase.listarTodo().stream().map(hotelesMapperDto::toResponse).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HotelesResponseDto crear(@Valid @RequestBody HotelesRequestDto hoteles) {
		return hotelesMapperDto.toResponse(hotelesUseCase.guardar(hotelesMapperDto.toDomain(hoteles)));
	}
	

	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public HotelesResponseDto buscarPorId(@RequestParam int id) {
	    return hotelesMapperDto.toResponse(hotelesUseCase.buscarPorId(id));
	}
	
	@GetMapping("/buscarPorNombre")
	@ResponseStatus(HttpStatus.OK)
	public List<HotelesResponseDto> hotelesPorNombre(@RequestParam String nombre) {
		return hotelesUseCase.hotelesPorNombre(nombre).stream().map(hotelesMapperDto::toResponse).toList();
	}

	@GetMapping("/buscarPorIdPaquetesDetalles")
	@ResponseStatus(HttpStatus.OK)
	public List<HotelesResponseDto> hotelesPorIdPaquetesDetalles(@RequestParam int idPaquetesDetalles) {
		return hotelesUseCase.hotelesPorIdPaquetesDetalles(idPaquetesDetalles).stream().map(hotelesMapperDto::toResponse).toList();
	}

	@GetMapping("/fecha-checkin")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelesResponseDto> listarPorFechaDeCheckin(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return hotelesUseCase.listarPorFechaDeCheckin(fecha)
                .stream()
                .map(hotelesMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/fecha-checkout")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelesResponseDto> listarPorFechaDeCheckout(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return hotelesUseCase.listarPorFechaDeCheckout(fecha)
                .stream()
                .map(hotelesMapperDto::toResponse)
                .toList();
    }


    @GetMapping("/rango-fechas")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelesResponseDto> listarPorRangoDeFechas(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate inicio,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fin) {

        return hotelesUseCase.listarPorRangoDeFechas(inicio, fin)
                .stream()
                .map(hotelesMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/isFechaExtra")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelesResponseDto> hotelesConfechaExtraCheckin() {

        return hotelesUseCase.hotelesConfechaExtraCheckin()
                .stream()
                .map(hotelesMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/fecha-extra-checkin")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelesResponseDto> listarPorFechaExtraCheckin(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return hotelesUseCase.listarPorFechaExtraCheckin(fecha)
                .stream()
                .map(hotelesMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/fecha-extra-checkout")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelesResponseDto> listarPorFechaExtraCheckout(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return hotelesUseCase.listarPorFechaExtraCheckout(fecha)
                .stream()
                .map(hotelesMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/rango-fechas-extra")
    @ResponseStatus(HttpStatus.OK)
    public List<HotelesResponseDto> listarPorRangoDeFechasExtras(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate inicio,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fin) {

        return hotelesUseCase.listarPorRangoDeFechasExtras(inicio, fin)
                .stream()
                .map(hotelesMapperDto::toResponse)
                .toList();
    }
}
