package br.com.integrador.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.integrador.model.Usuario;
import br.com.integrador.service.AutenticaService;

/**
 * @author Rodrigo
 *
 */
@Path("/autenticacao")
public class AutenticacaoWS {
	AutenticaService autenticaService = new AutenticaService();
	
	@POST
	@Path("/autenticarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
	public Usuario autenticarUsuario(Usuario user){
		System.out.println("ver se chegou aqui: "+user);
		Usuario usuario = new Usuario();
		System.out.println("chegou ate aqui...");
		autenticaService.autenticaUsuario(user);
		return usuario;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarCliente")
	public Usuario buscarClientes(Usuario user) {
		Usuario usuario = null;
		System.out.println("chegou ate aqui...");
		user = autenticaService.autenticaUsuario(user);
		return usuario;
	}

}
