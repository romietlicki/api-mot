package br.com.integrador.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.integrador.model.Lead;
import br.com.integrador.model.StatusLead;
import br.com.integrador.service.LeadService;

/**
 * @author Rodrigo
 *
 */
@Path("/lead")
public class LeadWS {
	
	LeadService leadService = new LeadService();
	
	/**
	 * Metodo que recebe as mensagens enviadas por clientes e adiciona em um lead. 
	 *
	 * @param lead
	 */
	@POST
	@Path("/recebeLeadCliente")
    @Consumes(MediaType.APPLICATION_JSON)
	public void recebeLeadCliente(Lead lead){
		List<StatusLead> listStatusLead = new ArrayList<StatusLead>();
		/*Anotacao anotacao = new Anotacao();
		StatusLead statusLead = new StatusLead();
		//Tarefa tarefa = new Tarefa();
		Lead leads = new Lead();
		Usuario usuario = new Usuario();
		
		//leads.setAnotacao(lead.getAnotacao());
		leads.setEmail(lead.getEmail());
		leads.setMensagem(lead.getMensagem());
		leads.setNome(lead.getNome());
		leads.setStatusLead(lead.getStatusLead());
		//leads.setTarefa(lead.getTarefa());
		leads.setUsuario(lead.getUsuario());
		leads.setTelefone(lead.getTelefone());
		leads.setValorOportunidade(lead.getValorOportunidade());
		
		statusLead.setLead(lead);
		statusLead.setStatus("Leads");
		listStatusLead.add(statusLead);
		
		//tarefa.setData(new Date());
		//tarefa.setLead(lead);
		
		usuario.setEmail(lead.getEmail());
		usuario.setId(1);
		usuario.setSenha("");
		usuario.setTipo(TipoUsuario.ADMINISTRADOR);
		System.out.println("username user: "+lead.getNome());
		usuario.setUsername(lead.getNome());
		
		if(leads.getMensagem()==null){
		tarefa.setMensagem("n/a");
		} else {
			tarefa.setMensagem(leads.getMensagem());
		}

		if(leads.getAnotacao() == null){
		anotacao.setAnotacao("n/a");
		} else {
			System.out.println("anotacao: "+ leads.getAnotacao().getAnotacao());
			anotacao.setAnotacao(leads.getAnotacao().getAnotacao());
		}
		anotacao.setLead(leads);
		

		//lead.setAnotacao(leads.getAnotacao() == null ? anotacao : leads.getAnotacao());
		lead.setStatusLead(leads.getStatusLead() == null ? statusLead : leads.getStatusLead());
		//lead.setTarefa(leads.getTarefa() == null ? tarefa : leads.getTarefa());
		lead.setValorOportunidade(leads.getValorOportunidade() == null ? 0 : leads.getValorOportunidade());
		lead.setUsuario(leads.getUsuario()== null ? usuario : leads.getUsuario());*/
		
		
		
		System.out.println("ver se chegou aqui: "+lead);
		leadService.recebeLeadClienteService(lead);
		 
	}
	
	@PUT
	@Path("/updateStatusLead")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateStatusLead(StatusLead statusLead){
		leadService.updateStatusLeadService(statusLead);
	}
	
	@POST
	@Path("/adicionaNovoLead")
	@Consumes(MediaType.APPLICATION_JSON)
	public void adicionarNovoLead(Lead lead){
		lead.setValorOportunidade(lead.getValorOportunidade().equals(null) ? 0 : lead.getValorOportunidade());
		lead.setData(new Date());
		leadService.adicionarNovoLead(lead);
	}
	
	@GET
	@Path("/buscarLeads/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Lead> buscarLeads(@PathParam("id")int idLoja){
		return leadService.buscarLeads(idLoja);
	}
	
	@GET
	@Path("/buscarLeadsPorId/{id},{idLoja}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Lead> buscarLeadsPorId(@PathParam("id") int id, @PathParam("idLoja") int idLoja) {
		return leadService.buscarLeadsPorId(id, idLoja);
	}
	
	@GET
	@Path("/buscarLeadPorStatus/{id},{idLoja}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Lead> buscarLeadsPorStatus(@PathParam("id") String status ,@PathParam("idLoja") int idLoja){
		return leadService.buscarLeadsPorStatus(status,idLoja);
	}
	
	@PUT
	@Path("/atualizarLead")
	@Produces(MediaType.APPLICATION_JSON)
	public void atualizaLead(Lead lead){
		leadService.atualizaLead(lead);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletaLead(Lead lead){
		leadService.deletarLead(lead);
	}

}
