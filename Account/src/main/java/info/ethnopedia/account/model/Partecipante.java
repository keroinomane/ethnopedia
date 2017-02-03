package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="partecipante")
@Table(name = "partecipanti")
public class Partecipante implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4942012458272682267L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String cognome;
	private String nome;
	
	public Partecipante() {
		
	}
	
	public Partecipante(String nome, String cognome) {
		super();
		this.cognome = cognome;
		this.nome = nome;
	}

	public Partecipante(Long id, String cognome, String nome) {
		super();
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
