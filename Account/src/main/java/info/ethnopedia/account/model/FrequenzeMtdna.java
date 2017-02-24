package info.ethnopedia.account.model;

public class FrequenzeMtdna {

	private String aplogruppo;
	private double percentuale;
	
	public FrequenzeMtdna() {
		
	}
	
	public FrequenzeMtdna(String aplogruppo, double percentuale) {
		super();
		this.aplogruppo = aplogruppo;
		this.percentuale = percentuale;
	}

	public String getAplogruppo() {
		return aplogruppo;
	}

	public void setAplogruppo(String aplogruppo) {
		this.aplogruppo = aplogruppo;
	}

	public double getPercentuale() {
		return percentuale;
	}

	public void setPercentuale(double percentuale) {
		this.percentuale = percentuale;
	}
	
	
}
