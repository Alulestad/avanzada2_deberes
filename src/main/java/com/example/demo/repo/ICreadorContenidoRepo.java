package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.CreadorContenido;
import com.example.demo.repo.modelo.dto.CreadorContenidoDTO;

public interface ICreadorContenidoRepo {
	
	public CreadorContenidoDTO seleccionarCreadorContenidoDTOPorVideoID(Integer id);

	//Joins
	public List<CreadorContenido> seleccionarTodosInnerJoin();
	
	public List<CreadorContenido> seleccionarTodosOuterRightJoin();
	
	public List<CreadorContenido> seleccionarTodosOuterLeftJoin();
	
	public List<CreadorContenido> seleccionarTodosOuterFullJoin();
	
	public List<CreadorContenido> seleccionarTodosWhereJoin();
	
	public List<CreadorContenido> seleccionarTodosJoinFetch();
	
	
}
