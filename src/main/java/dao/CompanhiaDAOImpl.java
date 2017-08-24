package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.jboss.logging.Logger;

import entity.Companhia;
import util.JPAUtil;

public class CompanhiaDAOImpl {
	
	private EntityManager entityManager;
	
	private Logger logger = Logger.getLogger(Companhia.class);

	public CompanhiaDAOImpl() {
		//logger.info("Construtor" + entityManagerFactory.getPersistenceUnitUtil());
	}
	
	public void salvarOuAtualizarCompanhia(Companhia companhia) {
		if (companhia.getId() != null) {
			atualizarCompanhia(companhia);
		}else {
			salvaCompanhia(companhia);
		}
	}
	
	public void salvaCompanhia(Companhia companhia) {
		entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(companhia);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	
			
	public void atualizarCompanhia(Companhia companhia) {
		Companhia comp = buscarCompanhiaPorId(companhia);
		companhia.setNome(companhia.getNome() + " CHANGED");
		StringBuilder sql = new StringBuilder();
		sql.append("update Companhia c SET c.nome = " + companhia.getNome() + " where c.id = " + companhia.getId());
		String result;
		
		if(comp != null) {
			entityManager.getTransaction().begin();
			result = (String) entityManager.createQuery(sql.toString()).getSingleResult();
			entityManager.close();
		}
	}
	
	public Companhia buscarCompanhiaPorId(Companhia companhia){
		entityManager = JPAUtil.getEntityManager();
		
		// StringBuilder sql = new StringBuilder();
		// sql.append("update c from Companhia c where c.id = " + companhia.getId());
		// return (Companhia) entityManager.createQuery(sql.toString()).getSingleResult();
		return (Companhia) entityManager.find(Companhia.class, companhia.getId());
	}
	
	public List<Companhia> buscarCompanhiaPorNome(String nomeCompanhia){
		entityManager = JPAUtil.getEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("select c from Companhia c where c.nome like " + nomeCompanhia );
		return (List<Companhia>) entityManager.createQuery(sql.toString()).getResultList();
	}
	
	public List<Companhia> getListCompanhia(){
		entityManager = JPAUtil.getEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("select c from Companhia c");
		return (List<Companhia>) entityManager.createQuery(sql.toString()).getResultList();
	}
}
