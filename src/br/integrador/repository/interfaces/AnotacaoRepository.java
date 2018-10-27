package br.integrador.repository.interfaces;

import java.util.List;

import br.com.integrador.model.Anotacao;

public interface AnotacaoRepository {
	
	public abstract List<Anotacao> buscarAnotacoesPorLead(int idlead);
	public abstract void adicionarAnotacaoLead(Anotacao anotacao);

}
