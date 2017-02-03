package info.ethnopedia.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="mtdnabozza")
@Table(name = "mtdnabozza")
public class MtdnaBozza implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String cognome;
	private String nome;
	private String aplogruppo;
	private String provincia;
	
	public MtdnaBozza() {
	}
	
	public MtdnaBozza(String username, String cognome, String nome, String aplogruppo, String provincia) {
		super();
		this.username = username;
		this.cognome = cognome;
		this.nome = nome;
		this.aplogruppo = aplogruppo;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAplogruppo() {
		return aplogruppo;
	}

	public void setAplogruppo(String aplogruppo) {
		this.aplogruppo = aplogruppo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}