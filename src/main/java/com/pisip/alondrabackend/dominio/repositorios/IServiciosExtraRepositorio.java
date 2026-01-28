package com.pisip.alondrabackend.dominio.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.pisip.alondrabackend.dominio.entidades.ServiciosExtra;

public interface IServiciosExtraRepositorio {
	ServiciosExtra guardar(ServiciosExtra serviciosExtra);

	Optional<ServiciosExtra> buscarPorId(int id);

	List<ServiciosExtra> listarTodo();

	void eliminar(int id);

	List<ServiciosExtra> serviciosExtraPorIdReserva(int idReserva);

	List<ServiciosExtra> serviciosExtraPorTipoServicio(String tipoServicio);

	List<ServiciosExtra> serviciosExtraPorRangoFechas(LocalDate inicio, LocalDate fin);
}
