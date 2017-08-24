package rn;

import java.util.List;

import javax.inject.Inject;

import dao.CompanhiaDAOImpl;
import entity.Companhia;


public class CompanhiaRN {

	private CompanhiaDAOImpl companhiaDAOImpl = new CompanhiaDAOImpl();
	
	public void salvarCompanhia(Companhia companhia) throws Exception{
		companhiaDAOImpl.salvarOuAtualizarCompanhia(companhia);
	}
	
	public List<Companhia> buscarCompanhiaNome(String nome){
		return companhiaDAOImpl.buscarCompanhiaPorNome(nome);
	}
	
	public List<Companhia> getListCompanhia(){
		return companhiaDAOImpl.getListCompanhia();
	}
	
}
