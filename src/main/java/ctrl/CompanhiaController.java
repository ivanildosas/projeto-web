package ctrl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Companhia;
import facade.CadastroFacade;

@SessionScoped
@ManagedBean
public class CompanhiaController {
	
	
	private CadastroFacade cadastroFacade = new CadastroFacade();
	
	private String message;
	
	private Companhia companhia;
	private List<Companhia> listaCompanhias;
	
	@PostConstruct
	public void init() {
		listaCompanhias = cadastroFacade.getListCompanhia();
		
		if(companhia == null ||  companhia.getId() == null) {
			companhia = new Companhia();
		}
	}
	

	public void salvar() {
		System.out.println("Teste - Salvar Companhia : " + companhia.getNome());
		
		try {
			cadastroFacade.salvaCompanhia(companhia);
			saveMessage();
			companhia = new Companhia();
			listaCompanhias = cadastroFacade.getListCompanhia();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
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
	
	public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastro Efetuado",  "Companhia: " + companhia.getNome() + " Cadastrada!") );
    }
	
}
