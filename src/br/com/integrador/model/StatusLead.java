package br.com.integrador.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Rodrigo
 *
 */
@Entity
@Table(name = "status_lead")
public class StatusLead {
	private int idStatus;
	private String status;
	private Lead lead;
	
	public StatusLead(){
		
	}
	
	@JsonCreator
	public StatusLead(@JsonProperty("idStatus") int idStatus,
			@JsonProperty("status") String status,
			@JsonProperty("lead") Lead lead) {
		super();
		this.idStatus = idStatus;
		this.status = status;
		this.lead = lead;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	@Column(nullable = false, length = 50)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "lead_id", nullable = true)
	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}
	
	
	
	

	
}
