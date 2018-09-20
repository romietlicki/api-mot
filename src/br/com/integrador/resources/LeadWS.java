package br.com.integrador.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.integrador.model.Lead;
import br.com.integrador.service.LeadService;

/**
 * @author Rodrigo
 *
 */
@Path("/lead")
public class LeadWS {
	
	LeadService leadService = new LeadService();
	
	@POST
	@Path("/recebeLeadCliente")
    @Consumes(MediaType.APPLICATION_JSON)
	public Lead recebeLeadCliente(Lead lead){
		System.out.println("ver se chegou aqui: "+lead);
		return leadService.recebeLeadClienteService(lead);
		 
	}

}
