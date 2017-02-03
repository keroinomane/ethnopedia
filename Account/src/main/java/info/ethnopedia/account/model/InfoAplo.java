package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="infoaplo")
@Table(name = "infoaplo")
public class InfoAplo implements java.io.Serializable {
	private String aplogruppo;
	private String contenuto;
	
	public InfoAplo() {
		
	}

	public InfoAplo(String aplogruppo, String contenuto) {
		super();
		this.aplogruppo = aplogruppo;
		this.contenuto = contenuto;
	}
	
	@Id
	public String getAplogruppo() {
		return aplogruppo;
	}

	public void setAplogruppo(String aplogruppo) {
		this.aplogruppo = aplogruppo;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	
	
}
