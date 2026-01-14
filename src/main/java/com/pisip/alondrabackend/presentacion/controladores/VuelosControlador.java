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
	@ResponseStatus(HttpStatus.OK)
	public List<VuelosResponseDto> listar(){
		return vuelosUseCase.listarTodo().stream().map(vuelosMapperDto::toResponse).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VuelosResponseDto crear(@Valid @RequestBody VuelosRequestDto vuelos) {
		return vuelosMapperDto.toResponse(vuelosUseCase.guardar(vuelosMapperDto.toDomain(vuelos)));
	}
	
	@GetMapping("/buscarPorId")
	@ResponseStatus(HttpStatus.OK)
	public VuelosResponseDto buscarPorId(@RequestParam int id) {
	    return vuelosMapperDto.toResponse(vuelosUseCase.buscarPorId(id));
	}
	
	@GetMapping("/buscarPorAerolinea")
	@ResponseStatus(HttpStatus.OK)
	public List<VuelosResponseDto> listarPorAerolinea(@RequestParam String aerolinea){
		return vuelosUseCase.listarPorAerolinea(aerolinea).stream().map(vuelosMapperDto::toResponse).toList();	
	}
	
	@GetMapping("/buscarPorOrigen")
	@ResponseStatus(HttpStatus.OK)
	public List<VuelosResponseDto> listarPorOrigen(@RequestParam String origen){
		return vuelosUseCase.listarPorOrigen(origen).stream().map(vuelosMapperDto::toResponse).toList();	
	}
	
	@GetMapping("/buscarPorDestino")
	@ResponseStatus(HttpStatus.OK)
	public List<VuelosResponseDto> listarPorDestino(@RequestParam String destino){
		return vuelosUseCase.listarPorDestino(destino).stream().map(vuelosMapperDto::toResponse).toList();	
	}
	
    @GetMapping("/fecha-salida")
    @ResponseStatus(HttpStatus.OK)
    public List<VuelosResponseDto> listarPorFechaSalida(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return vuelosUseCase.listarPorFechaSalida(fecha)
                .stream()
                .map(vuelosMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/fecha-llegada")
    @ResponseStatus(HttpStatus.OK)
    public List<VuelosResponseDto> listarPorFechaLlegada(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return vuelosUseCase.listarPorFechaLlegada(fecha)
                .stream()
                .map(vuelosMapperDto::toResponse)
                .toList();
    }


    @GetMapping("/rango-fechas")
    @ResponseStatus(HttpStatus.OK)
    public List<VuelosResponseDto> listarPorRangoFechas(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate inicio,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fin) {

        return vuelosUseCase.listarPorRangoFechas(inicio, fin)
                .stream()
                .map(vuelosMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/isFechaExtra")
    @ResponseStatus(HttpStatus.OK)
    public List<VuelosResponseDto> vuelosConFechaExtraSalida() {

        return vuelosUseCase.vuelosConFechaExtraSalida()
                .stream()
                .map(vuelosMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/fecha-extra-salida")
    @ResponseStatus(HttpStatus.OK)
    public List<VuelosResponseDto> listarPorFechaExtraSalida(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return vuelosUseCase.listarPorFechaExtraSalida(fecha)
                .stream()
                .map(vuelosMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/fecha-extra-llegada")
    @ResponseStatus(HttpStatus.OK)
    public List<VuelosResponseDto> listarPorFechaExtraLlegada(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        return vuelosUseCase.listarPorFechaExtraLlegada(fecha)
                .stream()
                .map(vuelosMapperDto::toResponse)
                .toList();
    }

    @GetMapping("/rango-fechas-extra")
    @ResponseStatus(HttpStatus.OK)
    public List<VuelosResponseDto> listarPorRangoFechasExtras(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate inicio,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fin) {

        return vuelosUseCase.listarPorRangoFechasExtras(inicio, fin)
                .stream()
                .map(vuelosMapperDto::toResponse)
                .toList();
    }
}
