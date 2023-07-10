package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IVideoRepo;
import com.example.demo.repo.modelo.Video;

@Service
public class VideoServiceImpl implements IVideoService {

	@Autowired
	private IVideoRepo iVideoRepo;

	@Override
	public List<Video> reporteEntreFechasResolucion(LocalDateTime fechaInicial, LocalDateTime fechaFinal,
			Integer resolucion) {
		return this.iVideoRepo.seleccionarEntreFechasResolucion(fechaInicial, fechaFinal, resolucion);
	}

	@Override
	public int actualizarComentariosPorDuracion(Double duracion, Boolean comentarios) {
		return this.iVideoRepo.actualizarComentariosPorDuracion(duracion, comentarios);
	}

	@Override
	public int eliminarPorFecha(LocalDateTime fecha) {

		return this.iVideoRepo.eliminarPorFecha(fecha);
	}

	@Override
	public List<Video> reportePorFechaSubida(LocalDateTime fechaSubida) {
		return this.iVideoRepo.seleccionarTodosPorFechaSubida(fechaSubida);
	}

	
}
