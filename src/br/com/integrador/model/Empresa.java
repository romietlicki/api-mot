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
@Table(name = "empresa")
public class Empresa {
	
	private int id;
	private String nome;
	private String logoPath;
	private String endereco;
	private String email;
	private String telefone;
	
	public Empresa(){
		super();
	}
	
	
	@JsonCreator
	public Empresa(@JsonProperty("id") int id,
			@JsonProperty("nome") String nome,
			@JsonProperty("logoPath") String logoPath,
			@JsonProperty("endereco") String endereco,
			@JsonProperty("email") String email,
			@JsonProperty("telefone") String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.logoPath = logoPath;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 150)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(nullable = false, length = 1000)
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	@Column(nullable = false, length = 150)
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Column(nullable = false, length = 150)
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
	
}
