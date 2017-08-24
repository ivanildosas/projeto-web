package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.jboss.logging.Logger;

import entity.Companhia;
import entity.Militar;

public class MilitarDAOImpl {

	private Session session;

	private Logger logger = Logger.getLogger(Militar.class);

	public MilitarDAOImpl(Session session) {
		logger.info("Construtor" + session);
		this.session = session;
	}
	
	public void salvarMilitar(Militar militar) {
		session.saveOrUpdate(militar);
	}
	
	public List<Militar> buscarMilitar(String nomeMilitar){
		Query query = (Query) session.createQuery("select * from militar as rsv where rsv.nomeGuerra like '%:nomeMilitar%'")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
		query.setParameter("nomeMilitar", nomeMilitar);
		return query.getResultList();
	}
	
	public List<Militar> todosMilitares(){
		Query query = (Query) session.createQuery("select * from militar as rsv")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
		return query.getResultList();
	}
}
