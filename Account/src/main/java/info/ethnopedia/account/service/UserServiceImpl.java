package info.ethnopedia.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Mtdna;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.repository.InfoAploRepository;
import info.ethnopedia.account.repository.MtdnaRepository;
import info.ethnopedia.account.repository.UserDatiRepository;
import info.ethnopedia.account.repository.UserRepository;
import info.ethnopedia.account.repository.YdnaRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private InfoAploRepository infoAploRepository;
    @Autowired
    private YdnaRepository ydnaRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    
    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public Ydna findById(long id) {
		return ydnaRepository.findById(id);
	}

	@Override
	public Ydna findByCognomeAndNome(String cognome, String nome) {
		Ydna ydna = ydnaRepository.findByCognomeAndNome(cognome, nome);
		if (ydna == null)
			ydna = ydnaRepository.findByCognome(cognome);
		return ydna;
	}
	
	public String getContent(String aplogruppo) {
		return infoAploRepository.getContent(aplogruppo);
	}
	
}
