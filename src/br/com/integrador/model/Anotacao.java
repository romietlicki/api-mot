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
@Table(name = "anotacao")
public class Anotacao {
	
	private int idAnotacao;
	private String anotacao;
	private Lead lead;
	
	public Anotacao(){
		super();
	}
	
	@JsonCreator
	public Anotacao(@JsonProperty("idAnotacao") int idAnotacao,
			@JsonProperty("anotacao") String anotacao,
			@JsonProperty("lead") Lead lead) {
		super();
		this.idAnotacao = idAnotacao;
		this.anotacao = anotacao;
		this.lead = lead;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdAnotacao() {
		return idAnotacao;
	}
	public void setIdAnotacao(int idAnotacao) {
		this.idAnotacao = idAnotacao;
	}
	@Column(nullable = false, length = 1000)
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	@OneToOne(mappedBy = "anotacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}
		
	
	

}
