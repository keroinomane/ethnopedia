package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.Autosomal;
import info.ethnopedia.account.model.TableMtdna;
import info.ethnopedia.account.model.TableYdna;

public interface StatisticheService {
	void deleteAllTableYdna();
	void deleteAllTableMtdna();
	void deleteAllAutosomal();
	List<String> getRegioni();
	List<String> getMacroregioniAutosomal();
	int countAploG(String regio);
	int countAploRegio(String aplo, String regio);
	int countRegio(String regio);
	int countAploMtdnaMacroRegio(String aplo, String macroregio);
	int countMacroRegio(String macroregio);
	double countSumAdmixMacroregio(String admix, String macro);
	int countAutoMacroregio(String macro);
	void save(TableYdna tableYdna);
	void save(TableMtdna tableMtdna);
	void save(Autosomal autosomal);
	List<TableYdna> findAll();
	List<TableMtdna> findAllMtdnaMacroreg();
	List<Autosomal> findAllAutosomal();
	int countCladeRegio(String clade, String regio);
	int countSubcladeRegio(String subclade, String regio);
	
	
}
