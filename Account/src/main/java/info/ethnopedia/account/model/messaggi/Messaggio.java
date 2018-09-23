package info.ethnopedia.account.model.messaggi;

import java.util.List;

public class Messaggio {
	
	private Mittente mittente;
	private List<String> destinatari;
	private String testo;
	
	public Messaggio() {
		
	}
	
	public Messaggio(Mittente mittente, List<String> destinatari, String testo) {
		super();
		this.mittente = mittente;
		this.destinatari = destinatari;
		this.testo = testo;
	}

	public Mittente getMittente() {
		return mittente;
	}

	public void setMittente(Mittente mittente) {
		this.mittente = mittente;
	}

	public List<String> getDestinatari() {
		return destinatari;
	}

	public void setDestinatari(List<String> destinatari) {
		this.destinatari = destinatari;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

}
