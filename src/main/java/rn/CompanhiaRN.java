package rn;

import java.util.List;

import javax.inject.Inject;

import dao.CompanhiaDAOImpl;
import entity.Companhia;


public class CompanhiaRN {

	@Inject
	private CompanhiaDAOImpl companhiaDAOImpl;
	
	public void salvarCompanhia(Companhia companhia) throws Exception{
		companhiaDAOImpl.salvaCompanhia(companhia);
	}
	
	public List<Companhia> buscarCompanhiaNome(String nome){
		return companhiaDAOImpl.buscarCompanhia(nome);
	}
	
	public List<Companhia> todasCompanhia(){
		return companhiaDAOImpl.todasCompanhia();
	}
	
}
