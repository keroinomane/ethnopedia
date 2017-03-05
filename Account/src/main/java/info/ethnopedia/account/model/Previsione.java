package info.ethnopedia.account.model;

import java.util.List;

public class Previsione {
	private List<String> macro;
	private String risposta;
	public Previsione() {
		
	}
	public Previsione(List<String> macro, String risposta) {
		super();
		this.macro = macro;
		this.risposta = risposta;
	}
	public List<String> getMacro() {
		return macro;
	}
	public void setMacro(List<String> macro) {
		this.macro = macro;
	}
	public String getRisposta() {
		return risposta;
	}
	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}
	
}
