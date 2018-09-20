package br.integrador.repository.interfaces;

import br.com.integrador.model.Lead;

/**
 * @author Rodrigo
 *
 */
public interface LeadRepository {
	
	public abstract Lead recebeLeadClienteService(Lead lead);

}
