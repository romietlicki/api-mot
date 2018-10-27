package br.com.integrador.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.integrador.model.Anotacao;
import br.com.integrador.service.AnotacaoService;

/**
 * @author Rodrigo
 *
 */
@Path("/anotacao")
public class AnotacaoWS {
	
	AnotacaoService anotacaoService = new AnotacaoService();
	
	@POST
	@Path("/inserirAnotacaoLead")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirAnotacaoLead(Anotacao anotacao){
		 anotacaoService.adicionarAnotacaoLead(anotacao);
	}
	
	@GET
	@Path("/buscarAnotacaoPorLead/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Anotacao> buscarAnotacaoPorLead(@PathParam("id") int idLead) {
		return anotacaoService.buscarAnotacoesPorLead(idLead);	
	}

}
