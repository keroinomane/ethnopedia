package info.ethnopedia.account.service;

import java.util.List;

import info.ethnopedia.account.model.CambioPassword;
import info.ethnopedia.account.model.ConfirmEmail;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.Ydna;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findByUsername(String username);
    Ydna findById(long id);
    Ydna findByCognomeAndNome(String cognome, String nome);
	void update(User user);
	String getContent(String aplogruppo);
	List<String> findEmailById(long id);
	User findByEmail(String username);
	void save (CambioPassword cambioPassword);
	void delete (CambioPassword cambioPassword);
	void delete (User user);
	CambioPassword findByLink(String link);
	ConfirmEmail findConfirmEmailByLink(String link);
	void updatePassword(CambioPassword cambioPassword);
	void save(ConfirmEmail confirmEmail);
}
