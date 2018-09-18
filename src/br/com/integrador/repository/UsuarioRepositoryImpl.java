package br.com.integrador.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.com.integrador.model.Usuario;
import br.com.integrador.util.jpa.EntityManagerProducer;
import br.integrador.repository.interfaces.UsuarioRepository;

/**
 * @author Rodrigo
 *
 */
public class UsuarioRepositoryImpl implements UsuarioRepository{
	
	@Inject
	private EntityManager manager;

	public Usuario inserirUsuario(Usuario usuario) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			return this.manager.merge(usuario);
		} catch (Exception e) {
			System.out.println("Erro..." + e.getMessage());
			return null;
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
	}
	
	public Usuario mudarSenhaUsuario(Usuario usuario) {
		Usuario user = new Usuario();
		try{
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
		manager.getTransaction().begin();
		String hqlUpdate = "update Usuario set senha =:senha where username = :username";
		Query query = manager.createQuery(hqlUpdate);
		query.setParameter("username", usuario.getUsername());
		query.setParameter("senha", usuario.getSenha());
		query.executeUpdate();
		} catch(HibernateException e){
			e.printStackTrace();
		} finally{
			manager.getTransaction().commit();
			manager.close();
		}
		return user;
	}

}
