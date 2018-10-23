package br.com.integrador.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.integrador.model.Lead;
import br.com.integrador.model.Veiculo;
import br.com.integrador.util.jpa.EntityManagerProducer;
import br.integrador.repository.interfaces.VeiculoRepository;

/**
 * @author Rodrigo
 *
 */
public class VeiculoRepositoryImpl implements VeiculoRepository{
	
	@Inject
	private EntityManager manager;

	public Veiculo cadastrarVeiculo(Veiculo veiculo) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		manager = emp.createEntityManager();
		manager.getTransaction().begin();
		return this.manager.merge(veiculo);
		}catch (Exception e){
			System.out.println("Erro ao cadastrar veiculo: "+e.getMessage());
			return null;
		}finally {
			System.out.println("Veiculo cadastrado com sucesso.");
			manager.getTransaction().commit();
			manager.close();
		}
	}
	
	public void cadastrarLeadVeiculo(Veiculo veiculo) {
		try{
		EntityManagerProducer emp = new EntityManagerProducer();
		manager = emp.createEntityManager();
		manager.getTransaction().begin();
		
		//update lead set veiculo_id = 1 where idLead = 3;
		Query query = manager.createQuery("update Lead set veiculo_id = :veiculoId where idLead = :idLead");
		
		query.setParameter("veiculoId", veiculo.getId());
		query.setParameter("idLead", veiculo.getLead().get(0).getIdLead());
		
		}catch (Exception e){
			System.out.println("Erro ao cadastrar cadastrar lead para o veiculo: "+e.getMessage());
		}finally {
			System.out.println("Veiculo cadastrado com sucesso.");
			manager.getTransaction().commit();
			manager.close();
		}
	}

	public List<Veiculo> buscarTodosVeiculos() {
		try{
			List<Veiculo> listVeiculo = new ArrayList<Veiculo>();
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			manager = emp.createEntityManager();
			Query query = manager.createQuery("from Veiculo");
			listVeiculo = query.getResultList();
			return listVeiculo; 
		}catch(Exception e){
			System.out.println("Erro ao fazer a busca dos veiculos "+e.getMessage());
			return null;
		}finally{
			manager.close();
		}
	}
	
	
	public List<Veiculo> buscarVeiculosPorLead(int idLead) {
		List<Veiculo> listVeiculo = new ArrayList<Veiculo>();
		try{
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			
			Query query = manager.createQuery("SELECT v from Lead l inner join l.veiculo v where l.idLead = :idLead");
			query.setParameter("idLead", idLead);
			listVeiculo = (ArrayList<Veiculo>) query.getResultList();
			
			return listVeiculo; 
		}catch(Exception e){
			System.out.println("Erro ao fazer a busca dos veiculos "+e.getMessage());
			return listVeiculo;
		}finally{
			manager.close();
		}
	}

	public List<Veiculo> buscarVeiculosPorId(int id) {
		try {
			EntityManagerProducer emp = new EntityManagerProducer();
			manager = emp.createEntityManager();
			this.manager.getTransaction().begin();
			Query query = this.manager
					.createQuery("from Veiculo v where v.id =:id");
			query.setParameter("id", id);
			List<Veiculo> veiculos = query.getResultList();
			this.manager.close();
			return veiculos;

		} catch (Exception e) {
			System.out.println("Erro buscar... " + e);
			return null;
		}
	}
	
}
