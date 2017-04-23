package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="altezza")
@Table(name = "altezza")
public class Altezza implements java.io.Serializable {

	/**
	 * Altezza di utenti con 4 nonni della stessa regione
	 */
	private static final long serialVersionUID = -2685806243352170838L;
	
	private Long id;
	private int centimetri;
	private String regione;
	
	public Altezza() {
		
	}
	
	public Altezza(Long id, int centimetri, String regione) {
		super();
		this.id = id;
		this.centimetri = centimetri;
		this.regione = regione;
	}
	
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	public int getCentimetri() {
		return centimetri;
	}

	public void setCentimetri(int centimetri) {
		this.centimetri = centimetri;
	}
	
	@NotNull
	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	
}
