package rn;

import java.util.List;

import javax.inject.Inject;

import dao.MilitarDAOImpl;
import entity.Militar;

public class MilitarRN {

	@Inject
	private MilitarDAOImpl militarDAOImpl;
	
	public void salvarMilitar(Militar companhia) throws Exception{
		militarDAOImpl.salvarMilitar(companhia);
	}
	
	public List<Militar> buscarMilitar(String nome){
		return militarDAOImpl.buscarMilitar(nome);
	}
	
	public List<Militar> todosMilitares(){
		return militarDAOImpl.todosMilitares();
	}
}
