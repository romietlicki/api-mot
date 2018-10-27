package br.com.integrador.service;

import java.util.List;

import br.com.integrador.model.Anotacao;
import br.com.integrador.repository.AnotacaoRepositoryImpl;

/**
 * @author Rodrigo
 *
 */
public class AnotacaoService {
	
	AnotacaoRepositoryImpl anotacaoRepositoryImpl = new AnotacaoRepositoryImpl();
	
	public List<Anotacao> buscarAnotacoesPorLead(int idlead){
		return anotacaoRepositoryImpl.buscarAnotacoesPorLead(idlead);
	}
	
	public void adicionarAnotacaoLead(Anotacao anotacao){
		 anotacaoRepositoryImpl.adicionarAnotacaoLead(anotacao);
	}

}
