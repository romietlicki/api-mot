package br.com.integrador.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.integrador.model.Lead;
import br.com.integrador.model.StatusLead;
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
	
	
	public void updateStatusLead(StatusLead statusLead) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("update StatusLead set status = :statusLeadDsc" +
    				" where idStatus = :idStatus");
			query.setParameter("statusLeadDsc", statusLead.getStatus());
			query.setParameter("idStatus", statusLead.getIdStatus());
			int result = query.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Erro..." + e.getMessage());
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
	}
	

}
