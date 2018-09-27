package br.com.integrador.repository;

import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

import br.com.integrador.model.Anotacao;
import br.com.integrador.model.Lead;
import br.com.integrador.model.Tarefa;
import br.com.integrador.model.Usuario;
import br.com.integrador.util.jpa.EntityManagerProducer;
import br.integrador.repository.interfaces.LeadRepository;

public class LeadRepositoryImpl  implements LeadRepository{
	
	@Inject
	private EntityManager manager;

	public void recebeMensagemCliente(Lead lead) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			//Anotacao anotacao = new Anotacao();
			
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			
			//anotacao.setAnotacao(lead.getAnotacao().getAnotacao().equals(null)?"n/a": lead.getAnotacao().getAnotacao());
			//anotacao.setLead(lead);
			//lead.setAnotacao(anotacao);
			//this.manager.merge(anotacao);
			this.manager.persist(lead.getStatusLead());
			this.manager.persist(lead);
		} catch (Exception e) {
			System.out.println("Erro..." + e.getMessage());
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
	}
	
	
	
/*	public void recebeMensagemCliente(Lead lead) {
		try{
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
		manager.getTransaction().begin();
		String hqlInsert = "insert into lead (email, mensagem, nome, telefone, valorOportunidade) select l.email l.mensagem l.nome, l.telefone, l.valorOportunidade from lead l";
		Query query = manager.createQuery(hqlInsert);
		query.setParameter("email", lead.getEmail());
		query.setParameter("mensagem", lead.getMensagem());
		query.setParameter("nome", lead.getNome());
		query.setParameter("telefone", lead.getTelefone());
		query.setParameter("valorOportunidade", lead.getValorOportunidade());
		query.executeUpdate();
		} catch(HibernateException e){
			e.printStackTrace();
		} finally{
			manager.getTransaction().commit();
			manager.close();
		}
	}*/
	

}
