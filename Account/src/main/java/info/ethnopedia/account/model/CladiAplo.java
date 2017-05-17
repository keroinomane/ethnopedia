package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="cladiaplo")
@Table(name = "cladiaplo")
public class CladiAplo implements java.io.Serializable {
	
	/**
	 * Cladi da mostrare per l'inserimento di DNA antico
	 */
	private static final long serialVersionUID = -1031744146498739123L;
	
	private String clade;
	private String aplogruppo;
	private String testo;
	
	public CladiAplo() {
	}
	
	public CladiAplo(String clade, String aplogruppo, String testo) {
		super();
		this.clade = clade;
		this.aplogruppo = aplogruppo;
		this.testo = testo;
	}
	
	@Id
	public String getClade() {
		return clade;
	}

	public void setClade(String clade) {
		this.clade = clade;
	}
	
	@NotNull
	public String getAplogruppo() {
		return aplogruppo;
	}

	public void setAplogruppo(String aplogruppo) {
		this.aplogruppo = aplogruppo;
	}

	@NotNull
	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
	
}