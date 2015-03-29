package br.com.soeirosantos.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.soeirosantos.entity.Participante;

@Stateless
public class Participantes {

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adicionar(Participante participante) {
		this.entityManager.persist(participante);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Participante> listaTodos() {
		return this.entityManager.createQuery("select p from Participante p", Participante.class).getResultList();
	}
	
}
