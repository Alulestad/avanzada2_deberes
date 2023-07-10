package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICreadorContenidoRepo;
import com.example.demo.repo.modelo.dto.CreadorContenidoDTO;

@Service
public class CreadorContenidoServiceImpl implements ICreadorContenidoService {

	@Autowired
	private ICreadorContenidoRepo iCreadorContenidoRepo;
	
	@Override
	public CreadorContenidoDTO buscarCreadorContenidoDTOPorVideoID(Integer id) {
		return this.iCreadorContenidoRepo.seleccionarCreadorContenidoDTOPorVideoID(id);
	}

}
