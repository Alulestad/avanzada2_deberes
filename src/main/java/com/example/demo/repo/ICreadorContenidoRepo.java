package com.example.demo.repo;

import com.example.demo.repo.modelo.dto.CreadorContenidoDTO;

public interface ICreadorContenidoRepo {
	
	public CreadorContenidoDTO seleccionarCreadorContenidoDTOPorVideoID(Integer id);

}
