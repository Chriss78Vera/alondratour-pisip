package com.pisip.alondrabackend.aplicacion.casosuso.entradas;

import java.time.LocalDate;
import java.util.List;

import com.pisip.alondrabackend.dominio.entidades.ServiciosExtra;

public interface IServiciosExtraUseCase {
	ServiciosExtra guardar(ServiciosExtra serviciosExtra);

	ServiciosExtra buscarPorId(int id);

	List<ServiciosExtra> listarTodo();

	void eliminar(int id);

	List<ServiciosExtra> serviciosExtraPorIdReserva(int idReserva);

	List<ServiciosExtra> serviciosExtraPorTipoServicio(String tipoServicio);

	List<ServiciosExtra> serviciosExtraPorRangoFechas(LocalDate inicio, LocalDate fin);
}
