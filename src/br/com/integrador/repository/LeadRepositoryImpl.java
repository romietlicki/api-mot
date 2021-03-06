package br.com.integrador.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;

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
			//this.manager.persist(lead.getStatusLead());
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
	
	
	public void adicionarNovoLead(Lead lead) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			StatusLead status = new StatusLead();
			status.setLead(lead);
			status.setStatus("Leads");
			lead.setStatusLead(status);
			this.manager.persist(status);
			this.manager.persist(lead);
			
			
		} catch (Exception e) {
			System.out.println("Erro..." + e.getMessage());
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
	}
	
	public List<Lead> buscarLeads(int idLoja) {
		List<Lead> listLead = new ArrayList<>();
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("from Lead where loja_id =:idLoja");
			query.setParameter("idLoja", idLoja);
			try {
				listLead = (ArrayList<Lead>) query.getResultList();
			return listLead;
		} catch (HibernateException e) {
			return null;
		} finally {
			manager.close();
		}
	}
	
	public List<Lead> buscarLeadsPorId(int id, int idLoja) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			this.manager.getTransaction().begin();
			Query query = this.manager
					.createQuery("from Lead where idLead =:id and loja_id =:idLoja");
			query.setParameter("id", id);
			query.setParameter("idLoja", idLoja);
			List<Lead> leads = query.getResultList();
			System.out.println("Leads.. "+ leads);
			return leads;

		} catch (Exception e) {
			System.out.println("Erro buscar... " + e);
			return null;
		} finally{
			this.manager.close();
		}
	}
	
	public List<Lead> buscarLeadsPorStatus(String status, int idLoja) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			this.manager.getTransaction().begin();
			Query query = this.manager
					.createQuery("select l from Lead l inner join l.statusLead sl where sl.status =:status and l.loja.id =:idLoja");
			query.setParameter("status", status);
			query.setParameter("idLoja", idLoja);
			List<Lead> leads = query.getResultList();
			System.out.println("Leads.. "+ leads);
			return leads;
		} catch (Exception e) {
			System.out.println("Erro buscar... " + e);
			return null;
		} finally{
			this.manager.close();
		}
	}
	
	
	public void atualizaLead(Lead lead) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			
			manager = emp.createEntityManager();
			manager.getTransaction().begin();
			int idLoja = lead.getLoja().getId();
			
			Query query = manager.createQuery("update Lead set nome = :nomeLead, email = :emailLead, valorOportunidade = :valorOportunidade, telefone = :telefoneLead, " +
    				"mensagem = :mensagemLead, cpf = :cpfLead, tipoForm = :tipoForm, endereco = :enderecoLead where idLead = :idLead and loja_id =:idLoja");
			
			query.setParameter("nomeLead", lead.getNome());
			query.setParameter("emailLead", lead.getEmail());
			query.setParameter("valorOportunidade", lead.getValorOportunidade());
			query.setParameter("telefoneLead", lead.getTelefone());
			query.setParameter("mensagemLead", lead.getMensagem());
			query.setParameter("cpfLead", lead.getCpf());
			query.setParameter("tipoForm", lead.getTipoForm());
			query.setParameter("enderecoLead", lead.getEndereco());
			query.setParameter("idLead", lead.getIdLead());
			query.setParameter("idLoja", idLoja);
			int result = query.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Erro..." + e.getMessage());
		} finally {
			manager.getTransaction().commit();
			manager.close();
		}
	}

	public void deletarLead(Lead lead) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		
		manager = emp.createEntityManager();
		manager.getTransaction().begin();
		
		this.manager.remove(lead);
		} catch(Exception e){
			System.out.println("erro ao deletar lead: "+e.getMessage());
		} finally{
			this.manager.getTransaction().commit();
			manager.close();
		}
		
	}

}
