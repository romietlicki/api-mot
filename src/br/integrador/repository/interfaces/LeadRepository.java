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
	public abstract void updateStatusLead(StatusLead statusLead);//verificar se ha necessidade de adicionar id da loja
	public abstract void adicionarNovoLead(Lead lead);//ok
	public abstract List<Lead> buscarLeads(int idLoja);//ok
	public List<Lead> buscarLeadsPorId(int id, int idLoja);//ok
	public abstract void atualizaLead(Lead lead);//ok
	public abstract void deletarLead(Lead lead);
	public abstract List<Lead> buscarLeadsPorStatus(String status, int idLoja);//ok

}
