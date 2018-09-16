package br.com.integrador.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.integrador.model.Usuario;
import br.com.integrador.service.UsuarioService;

@Path("/usuario")
public class UsuarioWS {
	
	UsuarioService usuarioService = new UsuarioService();
	@POST
	@Path("/inserirUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
	public Usuario inserirUsuario(Usuario user){
		System.out.println("ver se chegou aqui: "+user);
		System.out.println("chegou ate aqui...");
		return usuarioService.inserirUsuario(user);
		 
	}

}
