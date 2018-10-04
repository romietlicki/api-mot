package br.integrador.repository.interfaces;

import br.com.integrador.model.Lead;
import br.com.integrador.model.StatusLead;

/**
 * @author Rodrigo
 *
 */
public interface LeadRepository {
	
	public abstract void recebeMensagemCliente(Lead lead);
	public abstract void updateStatusLead(StatusLead statusLead);

}
