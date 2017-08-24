package rn;

import java.util.List;

import javax.inject.Inject;

import dao.ReservaDAOImpl;
import entity.Reserva;

public class ReservaRN {

	@Inject
	private ReservaDAOImpl reservaDAOImpl;
	
	public void salvarReserva(Reserva companhia) throws Exception{
		reservaDAOImpl.salvarReserva(companhia);
	}
	
	public List<Reserva> buscarReserva(String nome){
		return reservaDAOImpl.buscarReserva(nome);
	}
	
	public List<Reserva> todasReservas(){
		return reservaDAOImpl.todasReservas();
	}
	
	
	
	
}
