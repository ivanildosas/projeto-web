package rn;

import java.util.List;

import javax.inject.Inject;

import dao.MunicaoDAOImpl;
import entity.Municao;

public class MunicaoRN {


	@Inject
	private MunicaoDAOImpl municaoDAOImpl;
	
	
	public void salvaMunicao(Municao municao) throws Exception{
		municaoDAOImpl.salvaMunicao(municao);
	}
	
	public List<Municao> buscarMunicao(String calibre){
		return municaoDAOImpl.buscarMunicao(calibre);
	}
	
	public List<Municao> todasMunicao(){
		return municaoDAOImpl.todasMunicao();
	}
	
}
