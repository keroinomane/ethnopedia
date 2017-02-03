package info.ethnopedia.account.service;

import info.ethnopedia.account.model.UserDati;

public interface UserDatiService {

	UserDati save(UserDati userDati);
    UserDati findById(long id);
    UserDati findByCognomeAndNome(String cognome, String nome);
}
