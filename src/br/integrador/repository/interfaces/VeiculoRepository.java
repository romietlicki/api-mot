package br.integrador.repository.interfaces;

import java.util.List;

import br.com.integrador.model.Veiculo;

public interface VeiculoRepository {
	
	public abstract Veiculo cadastrarVeiculo(Veiculo veiculo);
	public abstract List<Veiculo> buscarTodosVeiculos();
	public abstract List<Veiculo> buscarVeiculosPorId(int id);

}
