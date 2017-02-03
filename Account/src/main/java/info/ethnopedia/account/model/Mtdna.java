package info.ethnopedia.account.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="mtdna")
@Table(name = "mtdna")
public class Mtdna implements java.io.Serializable {
	
	@EmbeddedId
	private MtdnaId mtdnaId;
	private String clade;
	private String regione;
	private String macroregione;
	private Long id;
	
	public Mtdna() {
	}

	public Mtdna(MtdnaId mtdna, String cla, String reg, String mac) {
		this.mtdnaId = mtdna;
		this.clade = cla;
		this.regione = reg;
		this.macroregione = mac;
	}

	public MtdnaId getMtdnaId() {
		return mtdnaId;
	}

	public void setMtdnaId(MtdnaId MtdnaId) {
		this.mtdnaId = MtdnaId;
	}
	
	@Column(name = "clade")
	public String getClade() {
		return clade;
	}
	
	public void setClade(String clade) {
		this.clade = clade;
	}
	
	@Column(name = "regione")
	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	@Column(name = "macroregione")
	public String getMacroregione() {
		return macroregione;
	}

	public void setMacroregione(String macroregione) {
		this.macroregione = macroregione;
	}
	
	@OneToOne
    @JoinColumn(name = "userId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Mtdna [MtdnaId=" + mtdnaId + ", clade=" + clade
				+ ", regione=" + regione
				+ ", macroregione=" + macroregione + "]";
	}

}