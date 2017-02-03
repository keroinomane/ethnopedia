package info.ethnopedia.account.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ydnaid")
@Embeddable
public class YdnaId implements java.io.Serializable {

	private String cognome;
	private String aplogruppo;
	private String provincia;
	
	@Id
	@Column(name = "cognome", nullable = false)
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Id
	@Column(name = "aplogruppo", nullable = false)
	public String getAplogruppo() {
		return aplogruppo;
	}
	public void setAplogruppo(String aplogruppo) {
		this.aplogruppo = aplogruppo;
	}
	
	@Id
	@Column(name = "provincia", nullable = false)
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public YdnaId () {
	}
	
	public YdnaId (String cog, String apl, String pro) {
		this.cognome = cog;
		this.aplogruppo = apl;
		this.provincia = pro;
	}
}