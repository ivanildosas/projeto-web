package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import entity.Companhia;
import util.JPAUtil;

public class CompanhiaDAOImpl {
	
	private EntityManager entityManager;
	
	private Logger logger = Logger.getLogger(Companhia.class);

	public CompanhiaDAOImpl() {
		//logger.info("Construtor" + entityManagerFactory.getPersistenceUnitUtil());
	}
	
	public void salvaCompanhia(Companhia companhia) {
		
		entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(companhia);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public List<Companhia> buscarCompanhia(String nomeCompanhia){
		/*Query query = (Query) session.createQuery("select * from companhia as comp where comp.nome like '%:nome%'")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
		query.setParameter("nome", nomeCompanhia);

		return query.getResultList();*/
		return null;
	}
	
	public List<Companhia> todasCompanhia(){
		/*
		Query query = (Query) session.createQuery("select * from companhia as comp")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
	
		return query.getResultList();
		*/
		return null;
	}
}
