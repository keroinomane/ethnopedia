package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.TableMtdna;
import info.ethnopedia.account.model.TableYdna;

public interface StatisticheService {
	void deleteAllTableYdna();
	List<String> getRegioni();
	int countAploG(String regio);
	int countAploRegio(String aplo, String regio);
	int countRegio(String regio);
	void save(TableYdna tableYdna);
	List<TableYdna> findAll();
	List<TableMtdna> findAllMtdnaMacroreg();
	int countCladeRegio(String clade, String regio);
	int countSubcladeRegio(String subclade, String regio);
	
}
