package info.ethnopedia.account.model;

import java.util.List;

public class PieChartData {
	
	private String macroregione;
	private List<FrequenzeMtdna> frequenzeMtdna;
	
	public PieChartData() {
		
	}
	
	public PieChartData(String macroregione, List<FrequenzeMtdna> frequenzeMtdna) {
		super();
		this.macroregione = macroregione;
		this.frequenzeMtdna = frequenzeMtdna;
	}

	public String getMacroregione() {
		return macroregione;
	}

	public void setMacroregione(String macroregione) {
		this.macroregione = macroregione;
	}

	public List<FrequenzeMtdna> getFrequenzeMtdna() {
		return frequenzeMtdna;
	}

	public void setFrequenzeMtdna(List<FrequenzeMtdna> frequenzeMtdna) {
		this.frequenzeMtdna = frequenzeMtdna;
	}

}
