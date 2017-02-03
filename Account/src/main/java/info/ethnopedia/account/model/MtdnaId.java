package info.ethnopedia.account.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class MtdnaId implements java.io.Serializable {

	private String nome;
	private String cognome;
	private String aplogruppo;
	private String provincia;
	
	@Id
	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
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
	
	public MtdnaId () {
	}
	
	public MtdnaId (String cog, String nom, String apl, String pro) {
		this.cognome = cog;
		this.nome = nom;
		this.aplogruppo = apl;
		this.provincia = pro;
	}
}