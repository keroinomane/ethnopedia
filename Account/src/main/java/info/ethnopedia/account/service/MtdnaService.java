package info.ethnopedia.account.service;

import info.ethnopedia.account.model.Mtdna;

public interface MtdnaService {
	 Mtdna findById(long id);
	 void save (Mtdna mtdna);
}
