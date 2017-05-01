package info.ethnopedia.account.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDati implements java.io.Serializable {

	private Long id;
	private String cognome;
	private String nome;
	public Boolean autosomal;
	private String sesso;
	private Date nascita;

	public UserDati () {
		
	}
	
	public UserDati (String cognome) {
		super();
		this.cognome = cognome;
	}

	public UserDati (String cognome, String nome) {
		super();
		this.cognome = cognome;
		this.nome = nome;
	}
	
	public UserDati(String cognome, String nome, String sesso) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.sesso = sesso;
	}
	
	public UserDati(String cognome, String nome, String sesso, Date nascita) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.sesso = sesso;
		this.nascita = nascita;
	}

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "cognome", nullable = false)
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Column(name = "nome", nullable = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "autosomal", nullable = true)
	public Boolean getAutosomal() {
		return autosomal;
	}

	public void setAutosomal(Boolean autosomal) {
		this.autosomal = autosomal;
	}
	
	@Column(name = "sesso", nullable = true)
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	@Column(name = "nascita", nullable = true)
	public Date getNascita() {
		return nascita;
	}

	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", cognome=" + cognome + ", nome=" + nome + "]";
	}
}
