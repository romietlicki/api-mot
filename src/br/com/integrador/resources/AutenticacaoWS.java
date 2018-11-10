package br.com.integrador.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import br.com.integrador.model.Usuario;
import br.com.integrador.service.AutenticaService;

/**
 * @author Rodrigo
 *
 */
@Path("/autenticacao")
public class AutenticacaoWS {
	@Context private HttpServletRequest request;
	AutenticaService autenticaService = new AutenticaService();
	boolean isAutenticated = false;
	
	@POST
	@Path("/autenticarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
	public Usuario autenticarUsuario(Usuario user){
		System.out.println("ver se chegou aqui: "+user);
		Usuario usuario = new Usuario();
		System.out.println("chegou ate aqui...");
		usuario = autenticaService.autenticaUsuario(user);
		if(!usuario.equals(null)){
			isAutenticated = true;
		}
		return usuario;
	}
	
	public void validarSessao(){
		if(isAutenticated){
			request.getSession(true);
		}
	}
	
}
