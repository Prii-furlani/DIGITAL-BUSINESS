package br.com.fiap.progamer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.progamer.model.Usuario;
import br.com.fiap.progamer.util.EntityManagerFacade;

public class UsuarioDao {
	
	private EntityManager em = EntityManagerFacade.get();
	
	public void save(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		
	}
	
	public List<Usuario> getAll() {
		String jpql = "SELECT s FROM Usuario s";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	public boolean exist(Usuario usuario) {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE email=:email AND senha=:senha", Usuario.class);
		query.setParameter("email", usuario.getEmail());
		query.setParameter("senha", usuario.getSenha());
		
		Usuario resultado;
		try {
			resultado = query.getSingleResult();
			if (resultado != null) return true;
		} catch (Exception e) {
			new Exception("Erro de Login");
		}
		return false;

	}
	
}
