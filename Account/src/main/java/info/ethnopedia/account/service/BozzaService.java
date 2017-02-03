package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.MtdnaBozza;
import info.ethnopedia.account.model.Partecipante;
import info.ethnopedia.account.model.YdnaBozza;

public interface BozzaService {
	
	void save(YdnaBozza ydnaBozza);
	void save(MtdnaBozza mtdnaBozza);
	void save(Partecipante partecipante);
	void deleteYdna(Long id);
	void deleteMtdna(Long id);
	List<YdnaBozza> findAllYdna();
	List<MtdnaBozza> findAllMtdna();
	List<Partecipante> findAllPartecipanti();
	Partecipante findPartecipanteInCorso();
	YdnaBozza findById(Long id);
	MtdnaBozza findMtdnaBozzaById(Long id);
	Partecipante findPartecipanteById(Long id);
}
