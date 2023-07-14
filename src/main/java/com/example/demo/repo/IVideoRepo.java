package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repo.modelo.Video;

public interface IVideoRepo {

	// Query dinamico
	// Actualizar
	// Eliminar

	// 1 hacer donde la fecha se ecneuentre entre x y y seleccionar los de
	// resolucion de z y entre x y y caso contrario todos los videos entre esas
	// fechas
	// 2 todos los videos que tienen duracion menor a x minutos poner los
	// comentarios
	// en falso o verdadero
	// 3 eliminar todos los videos de una fecha especifica.

	public List<Video> seleccionarEntreFechasResolucion(LocalDateTime fechaInicial, LocalDateTime fechaFinal,
			Integer resolucion);

	public int actualizarComentariosPorDuracion(Double duracion, Boolean comentarios);

	public int eliminarPorFecha(LocalDateTime fecha);

	public List<Video> seleccionarTodosPorFechaSubida(LocalDateTime fechaSubida);

	// Joins
	public List<Video> seleccionarTodosInnerJoin();

	public List<Video> seleccionarTodosOuterRightJoin();

	public List<Video> seleccionarTodosOuterLeftJoin();

	public List<Video> seleccionarTodosOuterFullJoin();

	public List<Video> seleccionarTodosWhereJoin();

}
