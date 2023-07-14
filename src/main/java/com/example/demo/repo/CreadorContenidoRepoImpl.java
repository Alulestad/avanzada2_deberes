package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.CreadorContenido;
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

		TypedQuery<CreadorContenidoDTO> myQuery = this.entityManager.createQuery(
				"select new com.example.demo.repo.modelo.dto.CreadorContenidoDTO(cc.nombreUsuario,cc.email) "
						+ "from CreadorContenido cc, Video v " + "where v.creadorContenido.id=cc.id and v.id=:datoID",
				CreadorContenidoDTO.class);
		myQuery.setParameter("datoID", id);

		return myQuery.getSingleResult();
	}

	@Override
	public List<CreadorContenido> seleccionarTodosInnerJoin() {
		TypedQuery<CreadorContenido> myQuery = this.entityManager
				.createQuery("" + "select cc from CreadorContenido cc inner join cc.videos v", CreadorContenido.class);

		List<CreadorContenido> creadorContenidos = myQuery.getResultList();

		creadorContenidos.forEach(cc -> {
			cc.getVideos().size();
		});

		return creadorContenidos;
	}

	@Override
	public List<CreadorContenido> seleccionarTodosOuterRightJoin() {
		TypedQuery<CreadorContenido> myQuery = this.entityManager
				.createQuery("select cc from CreadorContenido cc right join cc.videos v", CreadorContenido.class);

		List<CreadorContenido> creadorContenidos = myQuery.getResultList();

		creadorContenidos.forEach(cc -> {
			if (cc != null) {
				cc.getVideos().size();
			}
		});

		return creadorContenidos;
	}

	@Override
	public List<CreadorContenido> seleccionarTodosOuterLeftJoin() {
		// SQL
		// select * from creador_contenido crco left join video v on crco.crco_id =
		// v.vdeo_crco_id

		TypedQuery<CreadorContenido> myQuery = this.entityManager
				.createQuery("select cc from CreadorContenido cc left join cc.videos v", CreadorContenido.class);

		List<CreadorContenido> creadorContenidos = myQuery.getResultList();

		creadorContenidos.forEach(cc -> {
			if (cc != null) {
				cc.getVideos().size();
			}
		});

		return creadorContenidos;
	}

	@Override
	public List<CreadorContenido> seleccionarTodosOuterFullJoin() {
		TypedQuery<CreadorContenido> myQuery = this.entityManager
				.createQuery("select cc from CreadorContenido cc full join cc.videos v", CreadorContenido.class);

		List<CreadorContenido> creadorContenidos = myQuery.getResultList();

		creadorContenidos.forEach(cc -> {
			if (cc != null) {
				cc.getVideos().size();
			}
		});

		return creadorContenidos;
	}

	@Override
	public List<CreadorContenido> seleccionarTodosWhereJoin() {
		TypedQuery<CreadorContenido> myQuery = this.entityManager.createQuery(
				"select cc from CreadorContenido cc, Video v where cc=v.creadorContenido ", CreadorContenido.class);

		List<CreadorContenido> creadorContenidos = myQuery.getResultList();

		creadorContenidos.forEach(cc -> {

			cc.getVideos().size();

		});

		return creadorContenidos;
	}

}
