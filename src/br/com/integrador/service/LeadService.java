package br.com.integrador.service;

import br.com.integrador.model.Lead;
import br.com.integrador.model.StatusLead;
import br.com.integrador.repository.LeadRepositoryImpl;

/**
 * @author Rodrigo
 *
 */
public class LeadService {

	LeadRepositoryImpl leadRepositoryImpl = new LeadRepositoryImpl();
	
	public void recebeLeadClienteService(Lead lead){
		this.leadRepositoryImpl.recebeMensagemCliente(lead);
	}
	
	public void updateStatusLeadService(StatusLead statusLead){
		this.leadRepositoryImpl.updateStatusLead(statusLead);
	}
	
	
}
