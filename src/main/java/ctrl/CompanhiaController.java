package ctrl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import entity.Companhia;
import facade.CadastroFacade;

@ViewScoped
@ManagedBean
public class CompanhiaController {
	
	@Inject
	private CadastroFacade cadastroFacade;

	private Companhia companhia = new Companhia();
	private List<Companhia> listaCompanhias;
	
	

	public void salvar() {
		System.out.println("Teste - Salvar Companhia : " + companhia.getNome());
		/*
		try {
			cadastroFacade.salvaCompanhia(companhia);
			companhia = new Companhia();
			listaCompanhias = cadastroFacade.todasCompanhia();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
	public void editar(Companhia comp) {
		companhia = comp;
	}
	
	public void excluir(Companhia comp) {
		
	}

	public Companhia getCompanhia() {
		return companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}
	
	public List<Companhia> getListaCompanhias() {
		return listaCompanhias;
	}

	public void setListaCompanhias(List<Companhia> listaCompanhias) {
		this.listaCompanhias = listaCompanhias;
	}
	
}
