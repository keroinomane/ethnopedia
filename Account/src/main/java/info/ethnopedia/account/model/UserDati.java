package info.ethnopedia.account.model;

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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", cognome=" + cognome + ", nome=" + nome + "]";
	}
}
