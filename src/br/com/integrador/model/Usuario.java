package br.com.integrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JPasswordField;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Rodrigo
 *
 */
@Entity	
@Table(name = "usuario")
public class Usuario {
	
	private int id;
	private String username;
	private String senha;
	private String email;
	private TipoUsuario tipo;
	

	public Usuario(){
		super();
	}
	
	@JsonCreator
	public Usuario(@JsonProperty("id") int id,
			@JsonProperty("username") String username,
			@JsonProperty("senha") String senha,
			@JsonProperty("tipo") TipoUsuario tipo) {
		super();
		this.id = id;
		this.username = username;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable = false, length = 100)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(nullable = false, length = 100)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = true, length = 50)
	public TipoUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	@Column(nullable = false, length = 150)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}