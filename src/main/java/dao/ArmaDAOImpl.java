package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.jboss.logging.Logger;

import entity.Arma;
import entity.Companhia;

public class ArmaDAOImpl {
	
	private static final String EMPTY = "";
	private Session session;

	private Logger logger = Logger.getLogger(Companhia.class);

	public ArmaDAOImpl(Session session) {
		logger.info("Construtor" + session);
		this.session = session;
	}
	
	public void salvaArma(Arma arma) {
		session.saveOrUpdate(arma);
	}
	
	public List<Arma> buscarArma(Arma arma){
		String filtros = "";
		String sql = "select * from arma as arma where 1=1";
		if(EMPTY.equals(arma.getCalibre())) {
			filtros = "and arma.calibre = "+arma.getCalibre();
		}
		if(EMPTY.equals(arma.getFabricante())) {
			filtros = "and arma.fabricante = "+arma.getFabricante();
		}
		if(EMPTY.equals(arma.getModelo())) {
			filtros = "and arma.modelo = "+arma.getModelo();
		}
		if(EMPTY.equals(arma.getNumeroSerie())) {
			filtros = "and arma.numero_serie = "+arma.getNumeroSerie();
		}
		Query query = (Query) session.createQuery(sql+filtros)
				.setResultTransformer(new AliasToBeanResultTransformer(Arma.class));
	
		return query.getResultList();
	}
	
	public List<Arma> todasArmas(){
		Query query = (Query) session.createQuery("select * from arma as arma")
				.setResultTransformer(new AliasToBeanResultTransformer(Arma.class));
	
		return query.getResultList();
	}
}
