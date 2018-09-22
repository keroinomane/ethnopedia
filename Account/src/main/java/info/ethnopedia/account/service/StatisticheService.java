package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.Autosomal;
import info.ethnopedia.account.model.AutosomalPuri;
import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.EutestPlebe;
import info.ethnopedia.account.model.EutestPuri;
import info.ethnopedia.account.model.TableMtdna;
import info.ethnopedia.account.model.TableYdna;

public interface StatisticheService {
	void deleteAllTableYdna();
	void deleteAllTableMtdna();
	void deleteAllEutestPuri();
	void deleteAllAutosomal();
	void deleteAllAutosomalPuri();
	List<String> getRegioni();
	List<String> getProvinceConPiuCampioni();
	List<String> getMacroregioniAutosomal();
	List<String> getRegioniAutosomalPuri();
	int countAploG(String regio);
	int countAploRegio(String aplo, String regio);
	int countAploGProv(String prov);
	int countAploProv(String aplo, String prov);
	int countRegio(String regio);
	int countProv(String prov);
	int countAploMtdnaMacroRegio(String aplo, String macroregio);
	int countMacroRegio(String macroregio);
	double countSumAdmixMacroregio(String admix, String macro);
	double countSumAdmixRegio(String admix, String regione);
	int countAutoMacroregio(String macro);
	int countAutoRegio(String regione);
	void save(TableYdna tableYdna);
	void save(TableMtdna tableMtdna);
	void save(EutestPuri eutestPuri);
	void save(Autosomal autosomal);
	void save(AutosomalPuri autosomalPuri);
	List<TableYdna> findAll();
	List<TableMtdna> findAllMtdnaMacroreg();
	List<Eutest> findAllEutest();
	List<Autosomal> findAllAutosomal();
	List<AutosomalPuri> findAllAutosomalPuri();
	int countCladeRegio(String clade, String regio);
	int countSubcladeRegio(String subclade, String regio);
	String calcolaClosestPop(EutestPlebe e);
	String calcolaPureClosestPop(EutestPlebe e);
}
