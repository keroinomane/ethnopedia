package info.ethnopedia.account.model;

public class Frequenza {
	
	private String regione;
	private double frequenza;
	private int campioni;

	public Frequenza(String regione, double frequenza, int campioni) {
		super();
		this.regione = regione;
		this.frequenza = frequenza;
		this.setCampioni(campioni);
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public double getFrequenza() {
		return frequenza;
	}

	public void setFrequenza(double frequenza) {
		this.frequenza = frequenza;
	}

	public int getCampioni() {
		return campioni;
	}

	public void setCampioni(int campioni) {
		this.campioni = campioni;
	}
	
}
