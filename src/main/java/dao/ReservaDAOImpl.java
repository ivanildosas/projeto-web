package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.jboss.logging.Logger;

import entity.Companhia;
import entity.Reserva;

public class ReservaDAOImpl {

	private Session session;

	private Logger logger = Logger.getLogger(Reserva.class);

	public ReservaDAOImpl(Session session) {
		logger.info("Construtor" + session);
		this.session = session;
	}
	
	public void salvarReserva(Reserva reserva) {
		session.saveOrUpdate(reserva);
	}
	
	public List<Reserva> buscarReserva(String nomeReserva){
		Query query = (Query) session.createQuery("select * from reserva as rsv where rsv.descricao like '%:descricao%'")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
		query.setParameter("descricao", nomeReserva);
		return query.getResultList();
	}
	
	public List<Reserva> todasReservas(){
		Query query = (Query) session.createQuery("select * from reserva as rsv")
				.setResultTransformer(new AliasToBeanResultTransformer(Companhia.class));
		return query.getResultList();
	}
}
