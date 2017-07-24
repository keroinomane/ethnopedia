package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="autosomalpuri")
@Table(name = "autosomalpuri")
public class AutosomalPuri implements java.io.Serializable {
	
	
	/**
	 * Medie autosomiche regionali (utenti con 4 nonni della stessa regione)
	 */
	private static final long serialVersionUID = -9177387515955806100L;
	
	private String regione;
	private int campioni;
	private double baltic;
	private double nordic;
	private double atlantic;
	private double westmed;
	private double eastmed;
	private double westasian;
	private double mena;
	private double asian;
	private double ssa;
	
	public AutosomalPuri() {
		
	}
	
	public AutosomalPuri(String regione, int campioni, double baltic, double nordic, double atlantic, double westmed,
			double eastmed, double westasian, double mena, double asian, double ssa) {
		super();
		this.regione = regione;
		this.campioni = campioni;
		this.baltic = baltic;
		this.nordic = nordic;
		this.atlantic = atlantic;
		this.westmed = westmed;
		this.eastmed = eastmed;
		this.westasian = westasian;
		this.mena = mena;
		this.asian = asian;
		this.ssa = ssa;
	}
	
	@Id
	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public int getCampioni() {
		return campioni;
	}

	public void setCampioni(int campioni) {
		this.campioni = campioni;
	}

	public double getBaltic() {
		return baltic;
	}

	public void setBaltic(double baltic) {
		this.baltic = baltic;
	}

	public double getNordic() {
		return nordic;
	}

	public void setNordic(double nordic) {
		this.nordic = nordic;
	}

	public double getAtlantic() {
		return atlantic;
	}

	public void setAtlantic(double atlantic) {
		this.atlantic = atlantic;
	}

	public double getWestmed() {
		return westmed;
	}

	public void setWestmed(double westmed) {
		this.westmed = westmed;
	}

	public double getEastmed() {
		return eastmed;
	}

	public void setEastmed(double eastmed) {
		this.eastmed = eastmed;
	}

	public double getWestasian() {
		return westasian;
	}

	public void setWestasian(double westasian) {
		this.westasian = westasian;
	}

	public double getMena() {
		return mena;
	}

	public void setMena(double mena) {
		this.mena = mena;
	}

	public double getAsian() {
		return asian;
	}

	public void setAsian(double asian) {
		this.asian = asian;
	}

	public double getSsa() {
		return ssa;
	}

	public void setSsa(double ssa) {
		this.ssa = ssa;
	}

	@Override
	public String toString() {
		return "AutosomalPuri [regione=" + regione + ", campioni=" + campioni + ", baltic=" + baltic + ", nordic="
				+ nordic + ", atlantic=" + atlantic + ", westmed=" + westmed + ", eastmed=" + eastmed + ", westasian="
				+ westasian + ", mena=" + mena + ", asian=" + asian + ", ssa=" + ssa + "]";
	}
	
	
	
}
