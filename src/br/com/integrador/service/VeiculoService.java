package br.com.integrador.service;

import java.util.List;

import br.com.integrador.model.Lead;
import br.com.integrador.model.Veiculo;
import br.com.integrador.repository.VeiculoRepositoryImpl;

/**
 * @author Rodrigo
 *
 */
public class VeiculoService {
	
	VeiculoRepositoryImpl veiculoRepositoryImpl = new VeiculoRepositoryImpl();
	
	public Veiculo cadastrarVeiculo(Veiculo veiculo){
		return veiculoRepositoryImpl.cadastrarVeiculo(veiculo);
	}
	
	public List<Veiculo> buscarTodosOsVeiculos(){
		return veiculoRepositoryImpl.buscarTodosVeiculos();
	}
	
	public List<Veiculo> buscarVeiculosPorId(int id){
		return veiculoRepositoryImpl.buscarVeiculosPorId(id);
	}
	
	public void cadastrarLeadVeiculo(Veiculo veiculo){
		veiculoRepositoryImpl.cadastrarLeadVeiculo(veiculo);
	}
	
	public List<Veiculo> buscarVeiculosPorLead(int idLead){
		return veiculoRepositoryImpl.buscarVeiculosPorLead(idLead);
	}
	
}
