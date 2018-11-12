package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="confirmemail")
@Table(name = "confirmemail")
public class ConfirmEmail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2166683870492967949L;
	
	private String username;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String link;
	
	public ConfirmEmail() {
		
	}
	
	public ConfirmEmail(String username, String link, String email, String nome, String cognome, String password) {
		super();
		this.username = username;
		this.link = link;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
	}
	
	@Id
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
