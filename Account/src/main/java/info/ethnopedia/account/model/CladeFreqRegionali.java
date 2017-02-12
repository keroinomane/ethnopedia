package info.ethnopedia.account.model;

import java.util.List;

public class CladeFreqRegionali {
	private String nome;
	private List<Frequenza> frequenzePerOgniRegione;
	
	public CladeFreqRegionali(String nome, List<Frequenza> frequenzePerOgniRegione) {
		super();
		this.nome = nome;
		this.frequenzePerOgniRegione = frequenzePerOgniRegione;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Frequenza> getFrequenzePerOgniRegione() {
		return frequenzePerOgniRegione;
	}
	public void setFrequenzePerOgniRegione(List<Frequenza> frequenzePerOgniRegione) {
		this.frequenzePerOgniRegione = frequenzePerOgniRegione;
	}
}
