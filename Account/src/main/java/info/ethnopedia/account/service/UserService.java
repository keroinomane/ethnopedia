package info.ethnopedia.account.service;

import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    Ydna findById(long id);
    Ydna findByCognomeAndNome(String cognome, String nome);
	void update(User user);
	String getContent(String aplogruppo);
}
