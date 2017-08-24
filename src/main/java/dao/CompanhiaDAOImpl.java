package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.jboss.logging.Logger;

import entity.Companhia;

public class CompanhiaDAOImpl {

	private Session session;

	private Logger logger = Logger.getLogger(Companhia.class);

	public CompanhiaDAOImpl(Session session) {
		logger.info("Construtor" + session);
		this.session = session;
	}
	
	public void salvaCompanhia(Companhia companhia) {
		session.saveOrUpdate(companhia);
	}
	
	public List<Companhia> buscarCompanhia(String nomeCompanhia){
		Query query = (Query) session.createQuery("select * from companhia as comp where comp.nome like '%:nome%'")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
		query.setParameter("nome", nomeCompanhia);

		return query.getResultList();
	}
	
	public List<Companhia> todasCompanhia(){
		Query query = (Query) session.createQuery("select * from companhia as comp")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
	
		return query.getResultList();
	}
	
}
