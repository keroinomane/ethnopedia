package info.ethnopedia.account.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="ydna")
@Table(name = "ydna")
public class Ydna implements java.io.Serializable {
	
	@EmbeddedId
	private YdnaId ydnaId;
	private String nome;
	private String clade;
	private String subclade;
	private String downstream;
	private String regione;
	private String macroregione;
	private Long id;
	
	public Ydna() {
	}

	public Ydna(YdnaId ydna, String nom, String cla, String sub, String dow, String reg, String mac) {
		this.ydnaId = ydna;
		this.nome = nom;
		this.clade = cla;
		this.subclade = sub;
		this.downstream = dow;
		this.regione = reg;
		this.macroregione = mac;
	}
	
	public YdnaId getYdnaId() {
		return ydnaId;
	}

	public void setYdnaId(YdnaId ydnaId) {
		this.ydnaId = ydnaId;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "clade")
	public String getClade() {
		return clade;
	}

	public void setClade(String clade) {
		this.clade = clade;
	}
	
	@Column(name = "subclade")
	public String getSubclade() {
		return subclade;
	}

	public void setSubclade(String subclade) {
		this.subclade = subclade;
	}
	
	@Column(name = "downstream")
	public String getDownstream() {
		return downstream;
	}

	public void setDownstream(String downstream) {
		this.downstream = downstream;
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
		return "Ydna [YdnaId=" + ydnaId + ", nome=" + nome + ", clade=" + clade
				+ ", subclade=" + subclade + ", regione=" + regione
				+ ", macroregione=" + macroregione + "]";
	}

}