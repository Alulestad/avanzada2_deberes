package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.dto.CreadorContenidoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CreadorContenidoRepoImpl implements ICreadorContenidoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public CreadorContenidoDTO seleccionarCreadorContenidoDTOPorVideoID(Integer id) {
		
		TypedQuery<CreadorContenidoDTO> myQuery=this.entityManager
				.createQuery("select new com.example.demo.repo.modelo.dto.CreadorContenidoDTO(cc.nombreUsuario,cc.email) "
						+ "from CreadorContenido cc, Video v "
						+ "where v.creadorContenido.id=cc.id and v.id=:datoID",CreadorContenidoDTO.class);
		myQuery.setParameter("datoID", id);
		
		
		return myQuery.getSingleResult();
	}

}
