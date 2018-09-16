package br.com.integrador.service;

import br.com.integrador.model.Usuario;
import br.com.integrador.repository.UsuarioRepositoryImpl;

public class UsuarioService {

	UsuarioRepositoryImpl usuarioRepositoryImpl = new UsuarioRepositoryImpl(); 
	
	public Usuario inserirUsuario(Usuario user){
		System.out.println("chegou no service..");
		return this.usuarioRepositoryImpl.inserirUsuario(user);
		 
	}
	
}
