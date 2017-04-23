package info.ethnopedia.account.service;

import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.EutestPlebe;

public interface EutestService {

	EutestPlebe findById(long id);
	
	Eutest findPuroById(long id);
	
	void save(Eutest eutest);
	
	void save(EutestPlebe eutestPlebe);
}
