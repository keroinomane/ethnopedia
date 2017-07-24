package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="ancientYdna")
@Table(name = "ancientydna")
public class AncientYdna implements java.io.Serializable {
	
	/**
	 * Ritrovamenti di Y-DNA antico
	 */
	private static final long serialVersionUID = 2572152826927033067L;
	
	private String id;
	private String eta;
	private String aplogruppo;
	private String clade;
	private String terminalsnp;
	private String cultura;
	private String stato;
	private String location;
	private int fromybp;
	private Integer toybp;
	private String lastpaper;
	
	public AncientYdna() {
		
	}
	
	public AncientYdna(String id, String eta, String aplogruppo, String clade, String terminalsnp,
			String cultura, String stato, String location, int fromybp, Integer toybp, String lastpaper) {
		super();
		this.id = id;
		this.eta = eta;
		this.aplogruppo = aplogruppo;
		this.clade = clade;
		this.terminalsnp = terminalsnp;
		this.cultura = cultura;
		this.stato = stato;
		this.location = location;
		this.fromybp = fromybp;
		this.toybp = toybp;
		this.lastpaper = lastpaper;
	}
	
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@NotNull
	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}
	
	@NotNull
	public String getAplogruppo() {
		return aplogruppo;
	}

	public void setAplogruppo(String aplogruppo) {
		this.aplogruppo = aplogruppo;
	}

	public String getClade() {
		return clade;
	}

	public void setClade(String clade) {
		this.clade = clade;
	}

	public String getTerminalsnp() {
		return terminalsnp;
	}

	public void setTerminalsnp(String terminalsnp) {
		this.terminalsnp = terminalsnp;
	}

	public String getCultura() {
		return cultura;
	}

	public void setCultura(String cultura) {
		this.cultura = cultura;
	}

	@NotNull
	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	@NotNull
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@NotNull
	public int getFromybp() {
		return fromybp;
	}

	public void setFromybp(int fromybp) {
		this.fromybp = fromybp;
	}
	
	public Integer getToybp() {
		return toybp;
	}

	public void setToybp(Integer toybp) {
		this.toybp = toybp;
	}
	
	@NotNull
	public String getLastpaper() {
		return lastpaper;
	}

	public void setLastpaper(String lastpaper) {
		this.lastpaper = lastpaper;
	}
	
}
