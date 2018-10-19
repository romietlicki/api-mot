package br.com.integrador.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonManagedReference;
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
	private List<Lead> lead;
	private List<Veiculo> veiculo;
	
	public Empresa(){
		super();
	}
	
	
	@JsonCreator
	public Empresa(@JsonProperty("id") int id,
			@JsonProperty("nome") String nome,
			@JsonProperty("logoPath") String logoPath,
			@JsonProperty("endereco") String endereco,
			@JsonProperty("email") String email,
			@JsonProperty("telefone") String telefone,
			@JsonProperty("lead") List<Lead> lead,
			@JsonProperty("veiculo") List<Veiculo> veiculo) {
		super();
		this.id = id;
		this.nome = nome;
		this.logoPath = logoPath;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.lead = lead;
		this.veiculo = veiculo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable = true, length = 150)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(nullable = true, length = 1000)
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	@Column(nullable = true, length = 150)
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Column(nullable = true, length = 150)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(nullable = true, length = 50)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Lead> getLead() {
		return lead;
	}

	public void setLead(List<Lead> lead) {
		this.lead = lead;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
}
