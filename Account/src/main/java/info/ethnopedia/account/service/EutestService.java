package info.ethnopedia.account.service;

import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.EutestPlebe;
import info.ethnopedia.account.model.EutestPuri;

public interface EutestService {

	EutestPlebe findById(long id);
	
	EutestPuri findPuroById(long id);
	
	void save(Eutest eutest);
	
	void save(EutestPlebe eutestPlebe);
}
