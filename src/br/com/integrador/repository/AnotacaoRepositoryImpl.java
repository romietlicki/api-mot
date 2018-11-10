package br.com.integrador.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.integrador.model.Anotacao;
import br.com.integrador.model.Lead;
import br.com.integrador.util.jpa.EntityManagerProducer;
import br.integrador.repository.interfaces.AnotacaoRepository;

public class AnotacaoRepositoryImpl implements AnotacaoRepository {

	@Inject
	private EntityManager manager;	
	
	public List<Anotacao> buscarAnotacoesPorLead(int idlead) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		List<Anotacao> anotacoes = new ArrayList<Anotacao>();
		
		manager = emp.createEntityManager();
		this.manager.getTransaction().begin();
		Query query = this.manager
				.createQuery("from Anotacao where lead_id =:idLead");
		query.setParameter("idLead", idlead);
		return anotacoes = query.getResultList();

	} catch (Exception e) {
		System.out.println("Erro buscar... " + e);
		return null;
	} finally{
		this.manager.close();
		}
	}

	@Override
	public void adicionarAnotacaoLead(Anotacao anotacao) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			List<Lead> leadList = new ArrayList<Lead>();
			DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Lead lead = new Lead();
			Date date = new Date();
			anotacao.setData(dateformat.format(date));
			System.out.println("data: "+anotacao.getData());
			LeadRepositoryImpl leadRepo = new LeadRepositoryImpl();
			
			int idLoja= anotacao.getLead().getLoja().getId();
			
			leadList = leadRepo.buscarLeadsPorId(anotacao.getLead().getIdLead(), idLoja);
			lead = leadList.get(0);
			anotacao.setLead(lead);
			 this.manager.merge(anotacao);
			
		} catch (Exception e) {
			System.out.println("Erro..." + e.getMessage());
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
	}
	

}
