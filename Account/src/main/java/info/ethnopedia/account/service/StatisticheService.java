package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.TableMtdna;
import info.ethnopedia.account.model.TableYdna;

public interface StatisticheService {
	void deleteAllTableYdna();
	void deleteAllTableMtdna();
	List<String> getRegioni();
	int countAploG(String regio);
	int countAploRegio(String aplo, String regio);
	int countRegio(String regio);
	int countAploMtdnaMacroRegio(String aplo, String macroregio);
	int countMacroRegio(String macroregio);
	void save(TableYdna tableYdna);
	void save(TableMtdna tableMtdna);
	List<TableYdna> findAll();
	List<TableMtdna> findAllMtdnaMacroreg();
	int countCladeRegio(String clade, String regio);
	int countSubcladeRegio(String subclade, String regio);
	
}
