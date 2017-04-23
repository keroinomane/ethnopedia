package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.Altezza;

public interface AltezzaService {
	 Altezza findById(long id);
	 void save (Altezza altezza);
	 List<Integer> getAltezze();
	 List<String> getRegioni();
}
