package br.com.integrador.model;

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
@Table(name = "veiculo")
public class Veiculo {
	
	private int id;
	private String  titulo;
	private String descrição;
	private Double preco;
	private Double km;
	private String tipo; 
	private String ano;
	private String cor;
	private String fotoPath;
	private String modelo;
	private String marca;
	private String caracteristicas;
	private Empresa loja;
	private List<Lead> lead;
	//private idveículoLoja
	private String cambio;
	private String combustivel;
	
	public Veiculo(){
		
	}
	
	@JsonCreator
	public Veiculo(@JsonProperty("id") int id,
			@JsonProperty("titulo") String titulo,
			@JsonProperty("descrição") String descrição,
			@JsonProperty("preco") Double preco,
			@JsonProperty("km") Double km,
			@JsonProperty("tipo") String tipo,
			@JsonProperty("ano") String ano,
			@JsonProperty("cor") String cor,
			@JsonProperty("fotoPath") String fotoPath,
			@JsonProperty("modelo") String modelo,
			@JsonProperty("marca") String marca,
			@JsonProperty("caracteristicas") String caracteristicas,
			@JsonProperty("loja") Empresa loja,
			@JsonProperty("lead") List<Lead> lead,
			@JsonProperty("cambio") String cambio,
			@JsonProperty("combustivel") String combustivel) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descrição = descrição;
		this.preco = preco;
		this.km = km;
		this.tipo = tipo;
		this.ano = ano;
		this.cor = cor;
		this.fotoPath = fotoPath;
		this.modelo = modelo;
		this.marca = marca;
		this.caracteristicas = caracteristicas;
		this.loja = loja;
		this.lead = lead;
		this.cambio = cambio;
		this.combustivel = combustivel;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(nullable = true, length = 200)
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Column(nullable = true, length = 1000)
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	@Column(nullable = true, length = 50)
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Column(nullable = true, length = 50)
	public Double getKm() {
		return km;
	}
	public void setKm(Double km) {
		this.km = km;
	}
	@Column(nullable = true, length = 150)
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column(nullable = true, length = 150)
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	@Column(nullable = true, length = 150)
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	@Column(nullable = true, length = 1000)
	public String getFotoPath() {
		return fotoPath;
	}
	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
	}
	@Column(nullable = true, length = 200)
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	@Column(nullable = true, length = 150)
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Column(nullable = true, length = 1500)
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "loja_id", nullable = true)
	public Empresa getLoja() {
		return loja;
	}
	public void setLoja(Empresa loja) {
		this.loja = loja;
	}
	@JsonManagedReference
	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	public List<Lead> getLead() {
		return lead;
	}

	public void setLead(List<Lead> lead) {
		this.lead = lead;
	}
	@Column(nullable = true, length = 100)
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	@Column(nullable = true, length = 100)
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	

}
