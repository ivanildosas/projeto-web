package facade;

import entity.Acessorio;
import entity.Arma;
import entity.Companhia;
import entity.Militar;
import entity.Municao;
import entity.Reserva;
import rn.AcessorioRN;
import rn.ArmaRN;
import rn.CompanhiaRN;
import rn.MilitarRN;
import rn.MunicaoRN;
import rn.ReservaRN;
import java.util.List;

import javax.inject.Inject;

public class CadastroFacade {
	
	private CompanhiaRN companhiaRN = new CompanhiaRN();
	
	@Inject
	private ArmaRN armaRN;
	
	@Inject
	private MunicaoRN municaoRN;
	
	@Inject
	private AcessorioRN acessorioRN;
	
	@Inject
	private ReservaRN reservaRN;
	
	@Inject
	private MilitarRN militarRN;
	
	
	public List<Companhia> buscarCompanhiaNome(String nome){
		return companhiaRN.buscarCompanhiaNome(nome);
	}
	
	public void salvaCompanhia(Companhia companhia) throws Exception {
		companhiaRN.salvarCompanhia(companhia);
	}
	
	public List<Companhia> getListCompanhia(){
		return companhiaRN.getListCompanhia();
	}
	
	public void salvaArma(Arma arma) throws Exception{
		armaRN.salvaArma(arma);
	}
	
	public List<Arma> buscarArma(Arma arma){
		return armaRN.buscarArma(arma);
	}
	
	public List<Arma> todasArmas(){
		return armaRN.todasArmas();
	}
	
	public void salvaMunicao(Municao municao) throws Exception{
		municaoRN.salvaMunicao(municao);
	}
	
	public List<Municao> buscarMunicao(String calibre){
		return municaoRN.buscarMunicao(calibre);
	}
	
	public List<Municao> todasMunicao(){
		return municaoRN.todasMunicao();
	}
	
	public void salvaAcessorio(Acessorio acessorio) throws Exception{
		acessorioRN.salvaAcessorio(acessorio);
	}
	
	public List<Acessorio> buscarAcessorio(String nome){
		return acessorioRN.buscarAcessorio(nome);
	}
	
	public List<Acessorio> todasAcessorio(){
		return acessorioRN.todasAcessorio();
	}
	
	public List<Reserva> buscarReserva(String nome){
		return reservaRN.buscarReserva(nome);
	}
	
	public void salvarReserva(Reserva companhia) throws Exception {
		reservaRN.salvarReserva(companhia);
	}
	
	public List<Reserva> todasReservas(){
		return reservaRN.todasReservas();
	}
	
	public List<Militar> buscarMilitar(String nome){
		return militarRN.buscarMilitar(nome);
	}
	
	public void salvarMilitar(Militar companhia) throws Exception {
		militarRN.salvarMilitar(companhia);
	}
	
	public List<Militar> todosMilitares(){
		return militarRN.todosMilitares();
	}


}
