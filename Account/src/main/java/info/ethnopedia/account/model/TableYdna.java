package info.ethnopedia.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tableydna")
@Table(name = "`regioniydna`")
public class TableYdna implements java.io.Serializable {

	private String regione;
	private int campioni;
	private double e1b1b;
	private double g2a;
	private double i1;
	private double i2;
	private double j1;
	private double j2;
	private double r1a;
	private double r1b;
	private double t;
	
	public TableYdna() {
		
	}

	public TableYdna(String reg, int campioni, double[] aplo) {
		super();
		this.regione = reg;
		this.campioni  = campioni;
		this.e1b1b = aplo[0];
		this.g2a = aplo[1];
		this.i1 = aplo[2];
		this.i2 = aplo[3];
		this.j1 = aplo[4];
		this.j2 = aplo[5];
		this.r1a = aplo[6];
		this.r1b = aplo[7];
		this.t = aplo[8];
	}
	
	@Id
	@Column(name = "regione", nullable = false)
	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}
	
	@Column(name = "campioni", nullable = false)
	public int getCampioni() {
		return campioni;
	}

	public void setCampioni(int campioni) {
		this.campioni = campioni;
	}

	@Column(name = "e1b1b", nullable = false)
	public double getE1b1b() {
		return e1b1b;
	}

	public void setE1b1b(double e1b1b) {
		this.e1b1b = e1b1b;
	}
	
	@Column(name = "g2a", nullable = false)
	public double getG2a() {
		return g2a;
	}

	public void setG2a(double g2a) {
		this.g2a = g2a;
	}
	
	@Column(name = "i1", nullable = false)
	public double getI1() {
		return i1;
	}

	public void setI1(double i1) {
		this.i1 = i1;
	}
	
	@Column(name = "i2", nullable = false)
	public double getI2() {
		return i2;
	}

	public void setI2(double i2) {
		this.i2 = i2;
	}
	
	@Column(name = "j1", nullable = false)
	public double getJ1() {
		return j1;
	}

	public void setJ1(double j1) {
		this.j1 = j1;
	}
	
	@Column(name = "j2", nullable = false)
	public double getJ2() {
		return j2;
	}

	public void setJ2(double j2) {
		this.j2 = j2;
	}
	
	@Column(name = "r1a", nullable = false)
	public double getR1a() {
		return r1a;
	}

	public void setR1a(double r1a) {
		this.r1a = r1a;
	}
	
	@Column(name = "r1b", nullable = false)
	public double getR1b() {
		return r1b;
	}

	public void setR1b(double r1b) {
		this.r1b = r1b;
	}
	
	@Column(name = "t", nullable = false)
	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "TableYdna [regione=" + regione + ", campioni=" + campioni + ", e1b1b=" + e1b1b + ", g2a="
				+ g2a + ", i1=" + i1 + ", i2=" + i2 + ", j1=" + j1 + ", j2="
				+ j2 + ", r1a=" + r1a + ", r1b=" + r1b + ", t=" + t + "]";
	}
	
}
