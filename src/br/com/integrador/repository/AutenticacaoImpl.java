package br.com.integrador.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.com.integrador.model.Usuario;
import br.com.integrador.util.jpa.EntityManagerProducer;
import br.integrador.repository.interfaces.Autenticacao;

/**
 * @author Rodrigo
 *
 */
public class AutenticacaoImpl implements Serializable, Autenticacao{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario AutenticarUsuario(Usuario user) {
		Usuario usuario = new Usuario();
		
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("from Usuario p where p.username=:username and p.senha =:senha");
			query.setParameter("username", user.getUsername());
			query.setParameter("senha", user.getSenha());
			try {
			usuario = (Usuario) query.getSingleResult();
			System.out.println("Logado com sucesso!!");
			return usuario;
		} catch (HibernateException e) {
			System.out.println("Usuario ou senha incorretos! "+ e);
			return null;
		} finally {
			manager.close();
		}
	}
}
