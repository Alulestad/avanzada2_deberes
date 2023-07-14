package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.CreadorContenido;
import com.example.demo.repo.modelo.dto.CreadorContenidoDTO;

public interface ICreadorContenidoService {

	public CreadorContenidoDTO buscarCreadorContenidoDTOPorVideoID(Integer id);

	// Joins
	public List<CreadorContenido> buscarTodosInnerJoin();

	public List<CreadorContenido> buscarTodosOuterRightJoin();

	public List<CreadorContenido> buscarTodosOuterLeftJoin();

	public List<CreadorContenido> buscarTodosOuterFullJoin();

	public List<CreadorContenido> buscarTodosWhereJoin();
}
