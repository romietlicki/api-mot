package br.com.integrador.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.integrador.model.Lead;
import br.com.integrador.util.jpa.EntityManagerProducer;
import br.integrador.repository.interfaces.LeadRepository;

public class LeadRepositoryImpl  implements LeadRepository{
	
	@Inject
	private EntityManager manager;

	public Lead recebeLeadClienteService(Lead lead) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			return this.manager.merge(lead);
		} catch (Exception e) {
			System.out.println("Erro..." + e.getMessage());
			return null;
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
	}

}
