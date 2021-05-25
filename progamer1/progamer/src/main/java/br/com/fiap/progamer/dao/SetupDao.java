package br.com.fiap.progamer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.progamer.model.Setup;
import br.com.fiap.progamer.util.EntityManagerFacade;

public class SetupDao {
	
	private EntityManager em = EntityManagerFacade.get();

	public void save(Setup setup) {
		try {
			em.getTransaction().begin();
			em.persist(setup);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		
	}

	public List<Setup> getAll() {
		String jpql = "SELECT s from Setup s";
		TypedQuery<Setup> createQuery = em.createQuery(jpql, Setup.class);
		return createQuery.getResultList();
	}

	public Setup findById(Long codigo) {
		return em.find(Setup.class, codigo);
	}

	public void update(Setup setup) {
		em.getTransaction().begin();
		em.merge(setup);
		em.flush();
		em.getTransaction().commit();
	}

}
