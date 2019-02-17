package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.AncientYdna;
import info.ethnopedia.account.model.CladiAplo;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaId;

public interface YdnaService {

	void save(Ydna ydna);
	void save(AncientYdna ancientYdna);
	boolean exists(YdnaId ydnaId);
	boolean exists(AncientYdna ancientYdna);
	List<String> getCladiByAplo(String aplo);
	List<String> getSubcladiByClade(String clade);
	List<CladiAplo> getCladiByAploForAdna(String aplo);
	List<AncientYdna> findAllAncientYdna();
	AncientYdna findAncientYdnaById(String id);
	List<Ydna> getPersoneByClade(String clade, Long id);
	List<Ydna> getPersoneBySubClade(String subclade, Long id);
	List<Ydna> getPersoneByCognome(String cognome);
}
