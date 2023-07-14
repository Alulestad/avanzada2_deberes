package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICreadorContenidoRepo;
import com.example.demo.repo.modelo.CreadorContenido;
import com.example.demo.repo.modelo.dto.CreadorContenidoDTO;

@Service
public class CreadorContenidoServiceImpl implements ICreadorContenidoService {

	@Autowired
	private ICreadorContenidoRepo iCreadorContenidoRepo;

	@Override
	public CreadorContenidoDTO buscarCreadorContenidoDTOPorVideoID(Integer id) {
		return this.iCreadorContenidoRepo.seleccionarCreadorContenidoDTOPorVideoID(id);
	}

	@Override
	public List<CreadorContenido> buscarTodosInnerJoin() {
		return this.iCreadorContenidoRepo.seleccionarTodosInnerJoin();
	}

	@Override
	public List<CreadorContenido> buscarTodosOuterRightJoin() {
		return this.iCreadorContenidoRepo.seleccionarTodosOuterRightJoin();
	}

	@Override
	public List<CreadorContenido> buscarTodosOuterLeftJoin() {
		return this.iCreadorContenidoRepo.seleccionarTodosOuterLeftJoin();
	}

	@Override
	public List<CreadorContenido> buscarTodosOuterFullJoin() {
		return this.iCreadorContenidoRepo.seleccionarTodosOuterFullJoin();
	}

	@Override
	public List<CreadorContenido> buscarTodosWhereJoin() {
		return this.iCreadorContenidoRepo.seleccionarTodosWhereJoin();
	}

}
