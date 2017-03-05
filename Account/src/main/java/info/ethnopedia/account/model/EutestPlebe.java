package info.ethnopedia.account.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="eutestplebe")
@Table(name = "eutestplebe")
public class EutestPlebe implements java.io.Serializable {
	
	private Long id;
	private String cognome;
	private String nome;
	private String kitgedmatch;
    private double baltic;
    private double easteuro;
    private double northcentraleuro;
    private double atlantic;
    private double westmed;
    private double eastmed;
    private double westasian;
    private double middleastern;
    private double southasian;
    private double eastafrican;
    private double eastasian;
    private double siberian;
    private double westafrican;
    
    public EutestPlebe () {
    	
    }

	public EutestPlebe(Long id, String cognome, String nome, String kitgedmatch,
			double baltic, double easteuro, double northcentraleuro,
			double atlantic, double westmed, double eastmed, double westasian,
			double middleastern, double southasian, double eastafrican,
			double eastasian, double siberian, double westafrican) {
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.kitgedmatch = kitgedmatch;
		this.baltic = baltic;
		this.easteuro = easteuro;
		this.northcentraleuro = northcentraleuro;
		this.atlantic = atlantic;
		this.westmed = westmed;
		this.eastmed = eastmed;
		this.westasian = westasian;
		this.middleastern = middleastern;
		this.southasian = southasian;
		this.eastafrican = eastafrican;
		this.eastasian = eastasian;
		this.siberian = siberian;
		this.westafrican = westafrican;
	}
	
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@NotNull
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull
	public String getKitgedmatch() {
		return kitgedmatch;
	}

	public void setKitgedmatch(String kitgedmatch) {
		this.kitgedmatch = kitgedmatch;
	}

	@NotNull
	public double getBaltic() {
		return baltic;
	}

	public void setBaltic(double baltic) {
		this.baltic = baltic;
	}
	
	@NotNull
	public double getEasteuro() {
		return easteuro;
	}

	public void setEasteuro(double easteuro) {
		this.easteuro = easteuro;
	}
	
	@NotNull
	public double getNorthcentraleuro() {
		return northcentraleuro;
	}

	public void setNorthcentraleuro(double northcentraleuro) {
		this.northcentraleuro = northcentraleuro;
	}
	
	@NotNull
	public double getAtlantic() {
		return atlantic;
	}

	public void setAtlantic(double atlantic) {
		this.atlantic = atlantic;
	}
	
	@NotNull
	public double getWestmed() {
		return westmed;
	}

	public void setWestmed(double westmed) {
		this.westmed = westmed;
	}
	
	@NotNull
	public double getEastmed() {
		return eastmed;
	}

	public void setEastmed(double eastmed) {
		this.eastmed = eastmed;
	}
	
	@NotNull
	public double getWestasian() {
		return westasian;
	}

	public void setWestasian(double westasian) {
		this.westasian = westasian;
	}
	
	@NotNull
	public double getMiddleastern() {
		return middleastern;
	}

	public void setMiddleastern(double middleastern) {
		this.middleastern = middleastern;
	}
	
	@NotNull
	public double getSouthasian() {
		return southasian;
	}

	public void setSouthasian(double southasian) {
		this.southasian = southasian;
	}
	
	@NotNull
	public double getEastafrican() {
		return eastafrican;
	}

	public void setEastafrican(double eastafrican) {
		this.eastafrican = eastafrican;
	}
	
	@NotNull
	public double getEastasian() {
		return eastasian;
	}

	public void setEastasian(double eastasian) {
		this.eastasian = eastasian;
	}
	
	@NotNull
	public double getSiberian() {
		return siberian;
	}

	public void setSiberian(double siberian) {
		this.siberian = siberian;
	}
	
	@NotNull
	public double getWestafrican() {
		return westafrican;
	}

	public void setWestafrican(double westafrican) {
		this.westafrican = westafrican;
	}

	@Override
	public String toString() {
		return "Eutest [id=" + id + ", cognome=" + cognome + ", nome=" + nome
				+ ", kitgedmatch=" + kitgedmatch + ", baltic=" + baltic + ", easteuro=" + easteuro
				+ ", northcentraleuro=" + northcentraleuro + ", atlantic=" + atlantic + ", westmed=" + westmed
				+ ", eastmed=" + eastmed + ", westasian=" + westasian + ", middleastern=" + middleastern
				+ ", southasian=" + southasian + ", eastafrican=" + eastafrican + ", eastasian=" + eastasian
				+ ", siberian=" + siberian + ", westafrican=" + westafrican + "]";
	}
    
}
