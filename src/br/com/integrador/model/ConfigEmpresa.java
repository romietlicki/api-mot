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
public class ConfigEmpresa {
	
		private int idEmpresa;
		private String site;
		private String tokenMotorizei;
		
		public ConfigEmpresa(){
			super();
		}
		
		
		@JsonCreator
		public ConfigEmpresa(@JsonProperty("idEmpresa") int idEmpresa,
				@JsonProperty("site") String site,
				@JsonProperty("tokenMotorizei") String tokenMotorizei) {
			super();
			this.idEmpresa = idEmpresa;
			this.site = site;
			this.tokenMotorizei = tokenMotorizei;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getIdEmpresa() {
			return idEmpresa;
		}
		public void setIdEmpresa(int idEmpresa) {
			this.idEmpresa = idEmpresa;
		}
		@Column(nullable = false, length = 1000)
		public String getSite() {
			return site;
		}
		public void setSite(String site) {
			this.site = site;
		}
		@Column(nullable = false, length = 1000)
		public String getTokenMotorizei() {
			return tokenMotorizei;
		}
		public void setTokenMotorizei(String tokenMotorizei) {
			this.tokenMotorizei = tokenMotorizei;
		}

}
