package br.com.integrador.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Rodrigo
 *
 */
@Entity
@Table(name = "tarefa")
public class Tarefa {
	
	private int idTafera;
	private String data;
	private String mensagem;
	private Lead lead;
	
	public Tarefa(){
		super();
	}

	@JsonCreator
	public Tarefa(@JsonProperty("idTafera") int idTafera,
			@JsonProperty("data") String data,
			@JsonProperty("mensagem") String mensagem,
			@JsonProperty("lead") Lead lead) {
		super();
		this.idTafera = idTafera;
		this.data = data;
		this.mensagem = mensagem;
		this.lead = lead;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdTafera() {
		return idTafera;
	}

	public void setIdTafera(int idTafera) {
		this.idTafera = idTafera;
	}

	@Column(nullable = false, length = 50)
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	@Column(nullable = false, length = 1000)
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	/*@OneToOne(fetch = FetchType.LAZY, mappedBy = "tarefa", cascade = CascadeType.ALL)
	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}*/
	
	

}
