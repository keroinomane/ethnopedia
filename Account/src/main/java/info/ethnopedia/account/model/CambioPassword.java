package info.ethnopedia.account.model;

public class CambioPassword {
	
	private String username;
	private String link;
	private String email;
	
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

}
