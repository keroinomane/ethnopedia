package info.ethnopedia.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tablemtdna")
@Table(name = "`macroregionimtdna`")
public class TableMtdna implements java.io.Serializable {

	public String macroregione;
	public int campioni;
	public double h;
	public double h1;
	public double h2;
	public double h3;
	public double h4;
	public double h5;
	public double t1;
	public double t2;
	public double u1;
	public double u2;
	public double u3;
	public double u4;
	public double u5;
	public double u6;
	public double u7;
	public double u8;
	public double j;
	public double hv;
	public double k;
	public double n;
	public double r;
	public double i;
	public double m;
	public double w;
	public double x;
	public double l;
	public double v;
	
	public TableMtdna() {
		
	}

	public TableMtdna(String macroregione, int campioni, double[] campi) {
		super();
		this.macroregione = macroregione;
		this.campioni = campioni;
		this.h = campi[0];
		this.h1 = campi[1];
		this.h2 = campi[2];
		this.h3 = campi[3];
		this.h4 = campi[4];
		this.h5 = campi[5];
		this.hv = campi[6];
		this.i = campi[7];
		this.j = campi[8];
		this.k = campi[9];
		this.l = campi[10];
		this.m = campi[11];
		this.n = campi[12];
		this.r = campi[13];
		this.t1 = campi[14];
		this.t2 = campi[15];
		this.u1 = campi[16];
		this.u2 = campi[17];
		this.u3 = campi[18];
		this.u4 = campi[19];
		this.u5 = campi[20];
		this.u6 = campi[21];
		this.u7 = campi[22];
		this.u8 = campi[23];
		this.v = campi[24];
		this.w = campi[25];
		this.x = campi[26];
	}



	@Id
	@Column(name = "macroregione", nullable = false)
	public String getMacroregione() {
		return macroregione;
	}

	public void setMacroregione(String macroregione) {
		this.macroregione = macroregione;
	}
	
	public int getCampioni() {
		return campioni;
	}

	public void setCampioni(int campioni) {
		this.campioni = campioni;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getH1() {
		return h1;
	}

	public void setH1(double h1) {
		this.h1 = h1;
	}

	public double getH2() {
		return h2;
	}

	public void setH2(double h2) {
		this.h2 = h2;
	}

	public double getH3() {
		return h3;
	}

	public void setH3(double h3) {
		this.h3 = h3;
	}

	public double getH4() {
		return h4;
	}

	public void setH4(double h4) {
		this.h4 = h4;
	}

	public double getH5() {
		return h5;
	}

	public void setH5(double h5) {
		this.h5 = h5;
	}

	public double getT1() {
		return t1;
	}

	public void setT1(double t1) {
		this.t1 = t1;
	}

	public double getT2() {
		return t2;
	}

	public void setT2(double t2) {
		this.t2 = t2;
	}
	
	public double getU1() {
		return u1;
	}

	public void setU1(double u1) {
		this.u1 = u1;
	}

	public double getU2() {
		return u2;
	}

	public void setU2(double u2) {
		this.u2 = u2;
	}

	public double getU3() {
		return u3;
	}

	public void setU3(double u3) {
		this.u3 = u3;
	}

	public double getU4() {
		return u4;
	}

	public void setU4(double u4) {
		this.u4 = u4;
	}

	public double getU5() {
		return u5;
	}

	public void setU5(double u5) {
		this.u5 = u5;
	}

	public double getU6() {
		return u6;
	}

	public void setU6(double u6) {
		this.u6 = u6;
	}
	
	public double getU7() {
		return u7;
	}

	public void setU7(double u7) {
		this.u7 = u7;
	}

	public double getU8() {
		return u8;
	}

	public void setU8(double u8) {
		this.u8 = u8;
	}

	public double getJ() {
		return j;
	}

	public void setJ(double j) {
		this.j = j;
	}

	public double getHv() {
		return hv;
	}

	public void setHv(double hv) {
		this.hv = hv;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public double getN() {
		return n;
	}

	public void setN(double n) {
		this.n = n;
	}
	
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}

	public double getM() {
		return m;
	}

	public void setM(double m) {
		this.m = m;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}
	
}

