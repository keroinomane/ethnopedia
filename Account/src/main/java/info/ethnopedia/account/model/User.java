package info.ethnopedia.account.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "usersito")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String email;
    private String nome;
    private String cognome;
    private Boolean donatore;
    private String ruolo;
    private Boolean gdpr;
    
    @NotNull
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotNull
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

	public Boolean getDonatore() {
		return donatore;
	}

	public void setDonatore(Boolean donatore) {
		this.donatore = donatore;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Boolean getGdpr() {
		return gdpr;
	}

	public void setGdpr(Boolean gdpr) {
		this.gdpr = gdpr;
	}
   
}
