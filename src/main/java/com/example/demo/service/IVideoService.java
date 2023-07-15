package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Video;

public interface IVideoService {

	public List<Video> reporteEntreFechasResolucion(LocalDateTime fechaInicial, LocalDateTime fechaFinal,
			Integer resolucion);

	public int actualizarComentariosPorDuracion(Double duracion, Boolean comentarios);

	public int eliminarPorFecha(LocalDateTime fecha);

	public List<Video> reportePorFechaSubida(LocalDateTime fechaSubida);

	// Joins
	public List<Video> buscarTodosInnerJoin();

	public List<Video> buscarTodosOuterRightJoin();

	public List<Video> buscarTodosOuterLeftJoin();

	public List<Video> buscarTodosOuterFullJoin();

	public List<Video> buscarTodosWhereJoin();

	public List<Video> buscarTodosJoinFetch();
}
