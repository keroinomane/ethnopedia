package info.ethnopedia.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.repository.UserDatiRepository;

@Service
public class UserDatiServiceImpl implements UserDatiService {
    @Autowired
    private UserDatiRepository userDatiRepository;

	@Override
	public UserDati save(UserDati userDati) {
		return userDatiRepository.save(userDati);
	}

	@Override
	public UserDati findById(long id) {
		return userDatiRepository.findById(id);
	}

	@Override
	public UserDati findByCognomeAndNome(String cognome, String nome) {
		return userDatiRepository.findByCognomeAndNome(cognome, nome);
	}
	
}
