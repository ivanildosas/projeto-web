package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager; 
	
	private static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("projeto-webPU");
		}
		return entityManagerFactory;
	}
	
	public static EntityManager getEntityManager() {
		try {
			if(entityManager == null || !entityManager.isOpen()) {
				entityManagerFactory = getEntityManagerFactory();
				entityManager = entityManagerFactory.createEntityManager(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityManager;
	}
	
}

