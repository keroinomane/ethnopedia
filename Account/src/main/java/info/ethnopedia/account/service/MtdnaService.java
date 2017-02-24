package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.Mtdna;

public interface MtdnaService {
	 Mtdna findById(long id);
	 void save (Mtdna mtdna);
	 List<String> getAplogruppi();
	 List<String> getMacroregioni();
}
