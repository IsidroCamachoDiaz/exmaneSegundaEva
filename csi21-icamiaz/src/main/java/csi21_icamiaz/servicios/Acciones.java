package csi21_icamiaz.servicios;

import java.util.List;

import csi21_icamiaz.daos.reserva;
import csi21_icamiaz.daos.vajilla;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Acciones {

	public void insertarEntidad(EntityManager em,Object o) {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	public void eliminarEntidad(EntityManager em,Object o) {
		em.getTransaction().begin();
		em.remove(o);
		em.getTransaction().commit();
	}
	
	public void actualizarEntidad(EntityManager em,Object o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();
	}
	
	public List<vajilla> ListarVajillasConFiltro(EntityManager em,String query,String valorPuntos,String valor){
		TypedQuery <vajilla> consulta=em.createQuery(query, vajilla.class);
		consulta.setParameter(valorPuntos, valor);
		return consulta.getResultList();
	}
	
	public List<reserva> ListarReservasConfiltro(EntityManager em,String query,String valorPuntos,String valor){
		TypedQuery <reserva> consulta=em.createQuery(query, reserva.class);
		consulta.setParameter(valorPuntos, valor);
		return consulta.getResultList();
	}
	public List<vajilla> ListarVajillas(EntityManager em,String query){
		TypedQuery <vajilla> consulta=em.createQuery(query, vajilla.class);
		return consulta.getResultList();
	}
	public List<reserva> ListarReserva(EntityManager em,String query){
		TypedQuery <reserva> consulta=em.createQuery(query, reserva.class);
		return consulta.getResultList();
	}
}
