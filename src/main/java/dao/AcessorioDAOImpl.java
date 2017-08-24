package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.jboss.logging.Logger;

import entity.Acessorio;
import entity.Companhia;
import entity.Municao;

public class AcessorioDAOImpl {
	

	private Session session;

	private Logger logger = Logger.getLogger(Companhia.class);

	public AcessorioDAOImpl(Session session) {
		logger.info("Construtor" + session);
		this.session = session;
	}
	
	public void salvaAcessorio(Acessorio acessorio) {
		session.saveOrUpdate(acessorio);
	}
	
	public List<Acessorio> buscarAcessorio(String nome){
		Query query = (Query) session.createQuery("select * from acessorio as acessorio where acessorio.nome = :nome")
				.setResultTransformer(new AliasToBeanResultTransformer(Municao.class));
		query.setParameter("nome", nome);
		return query.getResultList();
	}
	
	public List<Acessorio> todasAcessorio(){
		Query query = (Query) session.createQuery("select * from acessorio as acessorio")
				.setResultTransformer(new AliasToBeanResultTransformer(Municao.class));
	
		return query.getResultList();
	}
}
