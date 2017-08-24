package rn;

import java.util.List;

import javax.inject.Inject;

import dao.AcessorioDAOImpl;
import entity.Acessorio;

public class AcessorioRN {

	@Inject
	private AcessorioDAOImpl acessorioDAOImpl;
	
	
	public void salvaAcessorio(Acessorio acessorio) throws Exception{
		acessorioDAOImpl.salvaAcessorio(acessorio);
	}
	
	public List<Acessorio> buscarAcessorio(String nome){
		return acessorioDAOImpl.buscarAcessorio(nome);
	}
	
	public List<Acessorio> todasAcessorio(){
		return acessorioDAOImpl.todasAcessorio();
	}
	
}
