package br.com.integrador.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.integrador.model.Lead;
import br.com.integrador.model.StatusLead;
import br.com.integrador.model.Veiculo;
import br.com.integrador.service.VeiculoService;

/**
 * @author Rodrigo
 *
 */
@Path("/veiculo")
public class VeiculoWS {
	
	VeiculoService veiculoService = new VeiculoService();
	
	@POST
	@Path("/cadastrarVeiculo")
	@Consumes(MediaType.APPLICATION_JSON)
	public Veiculo cadastrarVeiculo(Veiculo veiculo){
		System.out.println("teste veiculo ws "+ veiculo.getLead());
		return this.veiculoService.cadastrarVeiculo(veiculo);
	}
	
	@GET
	@Path("/buscarVeiculos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Veiculo> buscarTodosVeiculos(){
		return veiculoService.buscarTodosOsVeiculos();
	}
	
	@GET
	@Path("/buscarVeiculosPorId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Veiculo> buscarLeadsPorId(@PathParam("id") int id) {
		return veiculoService.buscarVeiculosPorId(id);
	}
	
	@GET
	@Path("/buscarVeiculosPorLead/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Veiculo> buscarVeiculosPorLead(@PathParam("id") int idLead) {
		return veiculoService.buscarVeiculosPorLead(idLead);
	}
	
	@PUT
	@Path("/cadastrarLeadVeiculo")
	@Produces(MediaType.APPLICATION_JSON)
	public void cadastrarLeadVeiculo(Veiculo veiculo){
		veiculoService.cadastrarLeadVeiculo(veiculo);
	}
	

}
