package br.com.fiap.progamer.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFacade {
	
	public static EntityManager get() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		return fabrica.createEntityManager();
		
	}

}
