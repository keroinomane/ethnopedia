package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.Eutest;

public interface EutestService {

	Eutest findById(long id);
	
	void save(Eutest eutest);
}
