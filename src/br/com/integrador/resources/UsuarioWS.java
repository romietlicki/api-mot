package br.com.integrador.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.integrador.mail.SmtpMail;
import br.com.integrador.model.Usuario;
import br.com.integrador.service.UsuarioService;

/**
 * @author Rodrigo
 *
 */
@Path("/usuario")
public class UsuarioWS {
	
	UsuarioService usuarioService = new UsuarioService();
	@POST
	@Path("/inserirUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
	public Usuario inserirUsuario(Usuario user){
		System.out.println("ver se chegou aqui: "+user);
		user.setLeads(user.getLeads() == null ? null : user.getLeads());
		System.out.println("chegou ate aqui...");
		return usuarioService.inserirUsuario(user);
		 
	}
	
	@POST
	@Path("/mudarSenha")
    @Consumes(MediaType.APPLICATION_JSON)
	public Usuario mudarSenha(Usuario user){
		System.out.println("ver se chegou aqui: "+user);
		System.out.println("chegou ate aqui...");
		SmtpMail smtpmail = new SmtpMail();
		//smtpmail.main(null);
		return usuarioService.mudarSenhaUsuario(user);
		 
	}

}
