package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="cambiopassword")
@Table(name = "cambiopassword")
public class CambioPassword implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2811264157679479568L;
	private String username;
	private String link;
	private String email;
	private String password;
	private String passwordConfirm;
	
	public CambioPassword() {
		
	}
	
	public CambioPassword(String username, String link, String email) {
		super();
		this.username = username;
		this.link = link;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Id
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
	
	@Transient
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
	
	
}
