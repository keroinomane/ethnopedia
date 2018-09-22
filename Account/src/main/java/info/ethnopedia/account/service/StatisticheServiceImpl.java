package info.ethnopedia.account.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Autosomal;
import info.ethnopedia.account.model.AutosomalPuri;
import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.EutestPlebe;
import info.ethnopedia.account.model.EutestPuri;
import info.ethnopedia.account.model.TableMtdna;
import info.ethnopedia.account.model.TableYdna;
import info.ethnopedia.account.repository.AutosomalPuriRepository;
import info.ethnopedia.account.repository.AutosomalRepository;
import info.ethnopedia.account.repository.EutestPuriRepository;
import info.ethnopedia.account.repository.EutestRepository;
import info.ethnopedia.account.repository.MtdnaRepository;
import info.ethnopedia.account.repository.TableMtdnaRepository;
import info.ethnopedia.account.repository.TableYdnaRepository;
import info.ethnopedia.account.repository.YdnaRepository;

@Service
public class StatisticheServiceImpl implements StatisticheService {
	
	@Autowired
	private TableYdnaRepository tyrep;
	
	@Autowired
	private TableMtdnaRepository tmrep;
	
	@Autowired
	private AutosomalRepository arep;
	
	@Autowired
	private AutosomalPuriRepository aPuriRep;
	
	@Autowired
	private YdnaRepository yrep;
	
	@Autowired
	private MtdnaRepository mrep;
	
	@Autowired
	private EutestRepository erep;
	
	@Autowired
	private EutestPuriRepository ePuriRep;
    
	@Override
	public void deleteAllTableYdna() {
		tyrep.deleteAll();
	}
	
	@Override
	public void deleteAllTableMtdna() {
		tmrep.deleteAll();
	}
	
	@Override
	public void deleteAllEutestPuri() {
		ePuriRep.deleteAll();
	}
	
	@Override
	public void deleteAllAutosomal() {
		arep.deleteAll();
	}
	
	@Override
	public void deleteAllAutosomalPuri() {
		aPuriRep.deleteAll();
	}

	@Override
	public List<String> getRegioni() {
		return yrep.getRegioni();
	}
	
	@Override
	public List<String> getProvinceConPiuCampioni() {
		return yrep.getProvinceConPiuCampioni();
	}
	
	@Override
	public List<String> getMacroregioniAutosomal() {
		return erep.getMacroregioni();
	}
	
	@Override
	public List<String> getRegioniAutosomalPuri() {
		return ePuriRep.getRegioni();
	}

	@Override
	public int countAploG(String regio) {
		return yrep.countAploG(regio);
	}

	@Override
	public int countAploRegio(String aplo, String regio) {
		return yrep.countAploRegio(aplo, regio);
	}
	
	@Override
	public int countAploGProv(String prov) {
		return yrep.countAploGProv(prov);
	}

	@Override
	public int countAploProv(String aplo, String prov) {
		return yrep.countAploProv(aplo, prov);
	}

	@Override
	public int countRegio(String regio) {
		return yrep.countRegio(regio);
	}
	
	@Override
	public int countProv(String prov) {
		return yrep.countProv(prov);
	}
	
	@Override
	public int countAploMtdnaMacroRegio(String aplo, String macroregio) {
		return mrep.countAploMtdnaMacroRegio(aplo, macroregio);
	}

	@Override
	public int countMacroRegio(String macroregio) {
		return mrep.countMacroRegio(macroregio);
	}
	
	@Override
	public int countCladeRegio(String clade, String regio) {
		return yrep.countCladeRegio(clade, regio);
	}
	@Override
	public int countSubcladeRegio(String subclade, String regio) {
		return yrep.countSubcladeRegio(subclade, regio);
	}
	
	@Override
	public void save(TableYdna tableYdna) {
		tyrep.save(tableYdna);
	}
	
	@Override
	public void save(TableMtdna tableMtdna) {
		tmrep.save(tableMtdna);
	}
	
	@Override
	public void save(EutestPuri eutestPuri) {
		ePuriRep.save(eutestPuri);
	}
	
	@Override
	public void save(Autosomal autosomal) {
		arep.save(autosomal);
	}
	
	@Override
	public void save(AutosomalPuri autosomalPuri) {
		aPuriRep.save(autosomalPuri);
	}

	@Override
	public List<TableYdna> findAll() {
		return tyrep.findAll();
	}

	@Override
	public List<TableMtdna> findAllMtdnaMacroreg() {
		return tmrep.findAll();
	}
	
	@Override
	public List<Eutest> findAllEutest() {
		return erep.findAll();
	}
	
	@Override
	public List<Autosomal> findAllAutosomal() {
		return arep.findAll();
	}

	@Override
	public List<AutosomalPuri> findAllAutosomalPuri() {
		return aPuriRep.findAll();
	}
    
	@Override
	public double countSumAdmixMacroregio(String admix, String mac) {
		
		double tot = 0;
		
		switch(admix) {
			case "baltic":
				tot = erep.mediaBaltic(mac);
				break;
			case "nordic":
				tot = erep.mediaNordic(mac);
				break;
			case "mena":
				tot = erep.mediaMena(mac);
				break;
			case "asian":
				tot = erep.mediaAsian(mac);
				break;
			case "ssa":
				tot = erep.mediaSsa(mac);
				break;
			case "atlantic":
				tot = erep.mediaAtlantic(mac);
				break;
			case "westmed":
				tot = erep.mediaWestmed(mac);
				break;
			case "eastmed":
				tot = erep.mediaEastmed(mac);
				break;
			case "westasian":
				tot = erep.mediaWestasian(mac);
				break;
		}
		
		return tot;
	}
	
	@Override
	public double countSumAdmixRegio(String admix, String regione) {
		
		double tot = 0;
		
		switch(admix) {
			case "baltic":
				tot = ePuriRep.mediaBaltic(regione);
				break;
			case "nordic":
				tot = ePuriRep.mediaNordic(regione);
				break;
			case "mena":
				tot = ePuriRep.mediaMena(regione);
				break;
			case "asian":
				tot = ePuriRep.mediaAsian(regione);
				break;
			case "ssa":
				tot = ePuriRep.mediaSsa(regione);
				break;
			case "atlantic":
				tot = ePuriRep.mediaAtlantic(regione);
				break;
			case "westmed":
				tot = ePuriRep.mediaWestmed(regione);
				break;
			case "eastmed":
				tot = ePuriRep.mediaEastmed(regione);
				break;
			case "westasian":
				tot = ePuriRep.mediaWestasian(regione);
				break;
		}
		
		return tot;
	}

	@Override
	public int countAutoMacroregio(String macro) {
		return erep.countAutoMacroregio(macro);
	}
	
	@Override
	public int countAutoRegio(String regione) {
		return ePuriRep.countAutoRegio(regione);
	}
	
	@Override
	public String calcolaClosestPop(EutestPlebe e) {
		int nordovest,nordest,centro,sud,sicilia,sardegna;
		nordovest=nordest=centro=sud=sicilia=sardegna=0;
		
		List<Autosomal> atList = findAllAutosomal();
    	double[] percent = new double [] {e.getBaltic()+e.getEasteuro(),e.getNorthcentraleuro(),e.getAtlantic(),e.getWestmed(),e.getEastmed(),e.getWestasian(),e.getMiddleastern(),e.getSouthasian()+e.getEastasian()+e.getSiberian(),e.getWestafrican()+e.getEastafrican()};
    	for (int i=0; i<9; i++) {
    		List<String> res = closest(percent[i], i, atList);
    		Iterator<String> it = res.iterator();
    		while(it.hasNext()) {
	    		switch(it.next()) {
		    		case "centro":
		    			centro++;
		    			break;
		    		case "nordest":
		    			nordest++;
		    			break;
		    		case "nordovest":
		    			nordovest++;
		    			break;
		    		case "sardegna":
		    			sardegna++;
		    			break;
		    		case "sicilia":
		    			sicilia++;
		    			break;
		    		case "sud":
		    			sud++;
		    			break;
	    		}  
    		}
    	}
		
		return calcola(nordovest,nordest,centro,sud,sicilia,sardegna);
	}
	
	public List<String> closest(double of, int admixture, List<Autosomal> in) {
	    double min = Double.MAX_VALUE;
	    List<String> result = new ArrayList<String>();
	    String riserva="";
	    Iterator<Autosomal> it = in.iterator();
	    while (it.hasNext()) {
	    	Autosomal at = it.next();
	    	if (!at.getMacroregione().equals("Svizzera")) {
		    	double diff = 0;
		    	switch(admixture) {
		    		case 0:
			    		diff = Math.abs(at.getBaltic() - of);
			    		break;
		    		case 1:
		    			diff = Math.abs(at.getNordic() - of);
			    		break;
		    		case 2:
		    			diff = Math.abs(at.getAtlantic() - of);
			    		break;
		    		case 3:
		    			diff = Math.abs(at.getWestmed() - of);
			    		break;
		    		case 4:
		    			diff = Math.abs(at.getEastmed() - of);
			    		break;
		    		case 5:
		    			diff = Math.abs(at.getWestasian() - of);
			    		break;
		    		case 6:
		    			diff = Math.abs(at.getMena() - of);
			    		break;
		    		case 7:
		    			diff = Math.abs(at.getAsian() - of);
			    		break;
		    		case 8:
		    			diff = Math.abs(at.getSsa() - of);
			    		break;		    	
		    	}
		    	if (diff < min) {
				    min = diff;		
				    riserva = at.getMacroregione();
		    	}
		    	if (admixture != 7 && admixture != 8 && diff < 1)
		    		result.add(at.getMacroregione());
	    	}
	    }
	    if (result.isEmpty() && admixture != 7)
    		result.add(riserva);
	    return result;
	}

	private String calcola(int nordovest, int nordest, int centro, int sud, int sicilia, int sardegna) {
		int max = max(new int[]{nordovest,nordest,centro,sud,sicilia,sardegna});
		String risp = "";
		if (nordovest==max)
			risp += "gli italiani nordoccidentali, ";
		if (nordest==max)
			risp += "gli italiani nordorientali, ";
		if (centro==max)
			risp += "gli italiani centrali, ";
		if (sud==max)
			risp += "gli italiani meridionali, ";
		if (sicilia==max)
			risp += "i siciliani, ";
		if (sardegna==max)
			risp += "i sardi, ";
		return risp.substring(0, risp.length()-2);
	}

	private int max(int[]val) {
		for (int i=1; i<6; i++) 
			if(val[0] < val[i])
				val[0] = val[i];
		return val[0];
	}
	
	@Override
	public String calcolaPureClosestPop(EutestPlebe e) {
		int ticino,valledaosta,piemonte,liguria,lombardia,veneto,trentino,friuli,emilia,toscana,umbria,marche,lazio,abruzzo,molise,campania,puglia,basilicata,calabria,sicilia,sardegna;

		ticino=valledaosta=piemonte=liguria=lombardia=veneto=trentino=friuli=emilia=toscana=umbria=marche=lazio=abruzzo=molise=campania=puglia=basilicata=calabria=sicilia=sardegna=0;
		
		List<AutosomalPuri> atList = findAllAutosomalPuri();
    	double[] percent = new double [] {e.getBaltic()+e.getEasteuro(),e.getNorthcentraleuro(),e.getAtlantic(),e.getWestmed(),e.getEastmed(),e.getWestasian(),e.getMiddleastern(),e.getSouthasian()+e.getEastasian()+e.getSiberian(),e.getWestafrican()+e.getEastafrican()};
    	for (int i=0; i<9; i++) {
    		List<String> res = closestPuro(percent[i], i, atList);
    		Iterator<String> it = res.iterator();
    		while(it.hasNext()) {
	    		switch(it.next()) {
		    		case "Ticino":
		    			ticino++;
		    			break;
		    		case "Valle d'Aosta":
		    			valledaosta++;
		    			break;
		    		case "Piemonte":
		    			piemonte++;
		    			break;
		    		case "Liguria":
		    			liguria++;
		    			break;
		    		case "Lombardia":
		    			lombardia++;
		    			break;
		    		case "Veneto":
		    			veneto++;
		    			break;
		    		case "Trentino - Alto Adige":
		    			trentino++;
		    			break;
		    		case "Friuli - Venezia Giulia":
		    			friuli++;
		    			break;
		    		case "Emilia - Romagna":
		    			emilia++;
		    			break;
		    		case "Toscana":
		    			toscana++;
		    			break;
		    		case "Umbria":
		    			umbria++;
		    			break;
		    		case "Marche":
		    			marche++;
		    			break;
		    		case "Lazio":
		    			lazio++;
		    			break;
		    		case "Abruzzo":
		    			abruzzo++;
		    			break;
		    		case "Molise":
		    			molise++;
		    			break;
		    		case "Campania":
		    			campania++;
		    			break;
		    		case "Puglia":
		    			puglia++;
		    			break;
		    		case "Basilicata":
		    			basilicata++;
		    			break;
		    		case "Calabria":
		    			calabria++;
		    			break;
		    		case "Sicilia":
		    			sicilia++;
		    			break;
		    		case "Sardegna":
		    			sardegna++;
		    			break;
	    		}  
    		}
    	}
		
		return calcolaPuro(ticino,valledaosta,piemonte,liguria,lombardia,veneto,trentino,friuli,emilia,toscana,umbria,marche,lazio,abruzzo,molise,campania,puglia,basilicata,calabria,sicilia,sardegna);
	}
	
	public List<String> closestPuro(double of, int admixture, List<AutosomalPuri> in) {
	    double min = Double.MAX_VALUE;
	    List<String> result = new ArrayList<String>();
	    String riserva="";
	    Iterator<AutosomalPuri> it = in.iterator();
	    while (it.hasNext()) {
	    	AutosomalPuri at = it.next();
		    double diff = 0;
		    switch(admixture) {
		    	case 0:
			   		diff = Math.abs(at.getBaltic() - of);
			   		break;
		    	case 1:
		    		diff = Math.abs(at.getNordic() - of);
			   		break;
		    	case 2:
		    		diff = Math.abs(at.getAtlantic() - of);
			   		break;
		    	case 3:
		    		diff = Math.abs(at.getWestmed() - of);
			   		break;
		    	case 4:
		    		diff = Math.abs(at.getEastmed() - of);
			   		break;
		    	case 5:
		    		diff = Math.abs(at.getWestasian() - of);
			   		break;
		    	case 6:
		    		diff = Math.abs(at.getMena() - of);
			   		break;
		    	case 7:
		    		diff = Math.abs(at.getAsian() - of);
			   		break;
		    	case 8:
		    		diff = Math.abs(at.getSsa() - of);
			   		break;		    	
		    }
		    if (diff < min) {
			    min = diff;		
			    riserva = at.getRegione();
		    }
		    if (admixture != 7 && admixture != 8 && diff < 1)
		    	result.add(at.getRegione());
	    }
	    if (result.isEmpty() && admixture != 7)
    		result.add(riserva);
	    return result;
	}
	
	private String calcolaPuro(int ticino, int valledaosta, int piemonte, int liguria, int lombardia, int veneto, int trentino, int friuli, int emilia, int toscana, int umbria, int marche, int lazio, int abruzzo, int molise, int campania, int puglia, int basilicata, int calabria, int sicilia, int sardegna) {
		int max = maxPuro(new int[]{ticino,valledaosta,piemonte,liguria,lombardia,veneto,trentino,friuli,emilia,toscana,umbria,marche,lazio,abruzzo,molise,campania,puglia,basilicata,calabria,sicilia,sardegna});
		String risp = "";
		if (ticino==max)
			risp += "i ticinesi, ";
		if (valledaosta==max)
			risp += "i valdostani, ";
		if (piemonte==max)
			risp += "i piemontesi, ";
		if (liguria==max)
			risp += "i liguri, ";
		if (lombardia==max)
			risp += "i lombardi, ";
		if (veneto==max)
			risp += "i veneti, ";
		if (trentino==max)
			risp += "i trentini e gli altoatesini, ";
		if (friuli==max)
			risp += "i friulani, ";
		if (emilia==max)
			risp += "gli emiliani e i romagnoli, ";
		if (toscana==max)
			risp += "i toscani, ";
		if (umbria==max)
			risp += "gli umbri, ";
		if (marche==max)
			risp += "i marchigiani, ";
		if (lazio==max)
			risp += "i laziali, ";
		if (abruzzo==max)
			risp += "gli abruzzesi, ";
		if (molise==max)
			risp += "i molisani, ";
		if (campania==max)
			risp += "i campani, ";
		if (puglia==max)
			risp += "i pugliesi, ";
		if (basilicata==max)
			risp += "i lucani, ";
		if (calabria==max)
			risp += "i calabresi, ";
		if (sicilia==max)
			risp += "i siciliani, ";
		if (sardegna==max)
			risp += "i sardi, ";
		return risp.substring(0, risp.length()-2);
	}
	
	private int maxPuro(int[]val) {
		for (int i=1; i<21; i++) 
			if(val[0] < val[i])
				val[0] = val[i];
		return val[0];
	}

}
