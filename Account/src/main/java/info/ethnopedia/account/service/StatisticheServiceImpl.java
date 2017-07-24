package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Autosomal;
import info.ethnopedia.account.model.AutosomalPuri;
import info.ethnopedia.account.model.Eutest;
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
	public int countRegio(String regio) {
		return yrep.countRegio(regio);
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


}
