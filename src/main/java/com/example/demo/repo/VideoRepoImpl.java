package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Video;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VideoRepoImpl implements IVideoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Video> seleccionarEntreFechasResolucion(LocalDateTime fechaInicial, LocalDateTime fechaFinal,
			Integer resolucion) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Video> myCriteriaQuery = myCriteriaBuilder.createQuery(Video.class);
		Root<Video> myTablaFrom = myCriteriaQuery.from(Video.class);

		Predicate entreFechas = myCriteriaBuilder.between(myTablaFrom.get("fechaSubida"), fechaInicial, fechaFinal);
		Predicate igualResolucion = myCriteriaBuilder.equal(myTablaFrom.get("resolucionVideoP"), resolucion);
		Predicate predicadoFinal = null;
		if (fechaInicial.compareTo(LocalDateTime.of(2005, 1, 1, 0, 0)) > 0
				&& fechaFinal.compareTo(LocalDateTime.of(2010, 1, 1, 0, 0)) < 0) {
			predicadoFinal = myCriteriaBuilder.and(entreFechas, igualResolucion);

		} else {
			predicadoFinal = entreFechas;
		}

		myCriteriaQuery.select(myTablaFrom).where(predicadoFinal);

		TypedQuery<Video> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getResultList();
	}

	@Override
	public int actualizarComentariosPorDuracion(Double duracion, Boolean comentarios) {
		// SQL: update video v set v.vdeo_comentarios=? where v.vdeo_duracion<?
		// JPQL: update Video v set v.comentarios=:datoComentarios where
		// v.duracion<:datoDuracion
		Query myQuery = this.entityManager
				.createQuery("update Video v set v.comentarios=:datoComentarios where v.duracion<:datoDuracion");

		myQuery.setParameter("datoComentarios", comentarios);
		myQuery.setParameter("datoDuracion", duracion);

		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarParaUsuarioYFecha(String usuario, LocalDateTime fecha) {
		// SQL: delete from video v where v.vdeo_usuario=? and v.vdeo_fecha_subida=?
		// JPQL: delete from Video v where v.usuario=:datoUsuario and v.fechaSubida=:datoFecha
		Query myQuery = this.entityManager
				.createQuery("delete from Video v where v.usuario=:datoUsuario and v.fechaSubida=:datoFecha");

		myQuery.setParameter("datoUsuario", usuario);
		myQuery.setParameter("datoFecha", fecha);

		return myQuery.executeUpdate();
	}

}
