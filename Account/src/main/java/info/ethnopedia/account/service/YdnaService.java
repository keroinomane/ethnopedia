package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaId;

public interface YdnaService {

	void save(Ydna ydna);
	boolean exists(YdnaId ydnaId);
	List<String> getCladiByAplo(String aplo);
	List<String> getSubcladiByClade(String clade);
	
}
