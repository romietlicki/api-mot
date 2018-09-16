package br.com.integrador.service;

import br.com.integrador.model.Usuario;
import br.com.integrador.repository.AutenticacaoImpl;

/**
 * @author Rodrigo
 *
 */
public class AutenticaService {
	
	AutenticacaoImpl autenticacao = new AutenticacaoImpl();
	
	public Usuario autenticaUsuario(Usuario user){
		
		Usuario usuario = new Usuario();
		usuario = autenticacao.AutenticarUsuario(user);
		
		return usuario;
	}

}
