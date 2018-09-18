package br.com.integrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Rodrigo
 *
 */
@Entity
@Table(name = "config_empresa")
public class Lead {
	
	private int idLead;
	private String nome;
	private String email;
	private String telefone;
	private String mensagem;
	
	public Lead(){
		super();
	}
	
	
	@JsonCreator
	public Lead(@JsonProperty("idLead") int idLead,
			@JsonProperty("nome") String nome,
			@JsonProperty("email") String email,
			@JsonProperty("telefone") String telefone,
			@JsonProperty("mensagem") String mensagem) {
		super();
		this.idLead = idLead;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagem = mensagem;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdLead() {
		return idLead;
	}
	public void setIdLead(int idLead) {
		this.idLead = idLead;
	}
	@Column(nullable = false, length = 150)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(nullable = false, length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(nullable = false, length = 50)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Column(nullable = false, length = 1000)
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	


}
