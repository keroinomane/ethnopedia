package info.ethnopedia.account.model;

import java.util.List;

public class PieChartData {
	
	private String macroregione;
	private int campioni;
	private List<FrequenzeMtdna> frequenzeMtdna;
	
	public PieChartData() {
		
	}
	
	public PieChartData(String macroregione, int campioni, List<FrequenzeMtdna> frequenzeMtdna) {
		super();
		this.macroregione = macroregione;
		this.campioni = campioni;
		this.frequenzeMtdna = frequenzeMtdna;
	}

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

	public List<FrequenzeMtdna> getFrequenzeMtdna() {
		return frequenzeMtdna;
	}

	public void setFrequenzeMtdna(List<FrequenzeMtdna> frequenzeMtdna) {
		this.frequenzeMtdna = frequenzeMtdna;
	}

}
