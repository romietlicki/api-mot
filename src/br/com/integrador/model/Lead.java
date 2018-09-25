package br.com.integrador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Rodrigo
 *
 */
@Entity
@Table(name = "lead")
public class Lead {
	
	private int idLead;
	private String nome;
	private String email;
	private Double valorOportunidade;
	private String telefone;
	private String mensagem;
	private List<StatusLead> statusLead = new ArrayList<>(); 
	private Usuario usuario;
	//private Tarefa tarefa;
	private Anotacao anotacao;
	
	public Lead(){
		super();
	}
	
	
	@JsonCreator
	public Lead(@JsonProperty("idLead") int idLead,
			@JsonProperty("nome") String nome,
			@JsonProperty("email") String email,
			@JsonProperty("valorOportunidade") Double valorOportunidade,
			@JsonProperty("telefone") String telefone,
			@JsonProperty("mensagem") String mensagem,
			@JsonProperty("statusLead") List<StatusLead> statusLead,
			@JsonProperty("usuario") Usuario usuario,
			//@JsonProperty("tarefa") Tarefa tarefa,
			@JsonProperty("anotacao") Anotacao anotacao) {
		super();
		this.idLead = idLead;
		this.nome = nome;
		this.email = email;
		this.valorOportunidade = valorOportunidade;
		this.telefone = telefone;
		this.mensagem = mensagem;
		this.statusLead = statusLead;
		this.usuario = usuario;
		//this.tarefa = tarefa;
		this.anotacao = anotacao;
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
	@Column(nullable = true, length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(nullable = true, length = 100)
	public Double getValorOportunidade() {
		return valorOportunidade;
	}
	public void setValorOportunidade(Double valorOportunidade) {
		this.valorOportunidade = valorOportunidade;
	}

	@Column(nullable = true, length = 50)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Column(nullable = true, length = 1000)
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@JsonManagedReference
	@OneToMany(mappedBy = "lead", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<StatusLead> getStatusLead() {
		return statusLead;
	}


	public void setStatusLead(List<StatusLead> statusLead) {
		this.statusLead = statusLead;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", nullable = true)
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarefa_id", nullable = true)
	public Tarefa getTarefa() {
		return tarefa;
	}

	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}*/

	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anotacao_id", nullable = true)
	public Anotacao getAnotacao() {
		return anotacao;
	}


	public void setAnotacao(Anotacao anotacao) {
		this.anotacao = anotacao;
	}
	*/
	

}
