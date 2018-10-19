package br.integrador.repository.interfaces;

import java.util.List;

import br.com.integrador.model.Lead;
import br.com.integrador.model.StatusLead;

/**
 * @author Rodrigo
 *
 */
public interface LeadRepository {
	
	public abstract void recebeMensagemCliente(Lead lead);
	public abstract void updateStatusLead(StatusLead statusLead);
	public abstract void adicionarNovoLead(Lead lead);
	public abstract List<Lead> buscarLeads();
	public List<Lead> buscarLeadsPorId(int id);
	public abstract void atualizaLead(Lead lead);
	public abstract void deletarLead(Lead lead);

}
