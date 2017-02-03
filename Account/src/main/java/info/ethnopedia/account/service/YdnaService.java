package info.ethnopedia.account.service;

import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaId;

public interface YdnaService {

	void save(Ydna ydna);
	boolean exists(YdnaId ydnaId);

}
