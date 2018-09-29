package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.CambioPassword;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.repository.CambioPasswordRepository;
import info.ethnopedia.account.repository.InfoAploRepository;
import info.ethnopedia.account.repository.UserRepository;
import info.ethnopedia.account.repository.YdnaRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private CambioPasswordRepository cambioPasswordRepository;
	@Autowired
    private InfoAploRepository infoAploRepository;
    @Autowired
    private YdnaRepository ydnaRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRuolo("user");
        user.setDonatore(false);
        userRepository.save(user);
    }
    
    @Override
    public void save(CambioPassword cambioPassword) {
    	cambioPasswordRepository.save(cambioPassword);
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
	public List<String> findEmailById(long id) {
		return userRepository.findEmailById(id);
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
	
	@Override
    public User findByEmail(String email) {
		List<User> user = userRepository.findByEmail(email);
		if (user.isEmpty())
			return null;
		else
			return user.get(0);
    }
	
	@Override
    public CambioPassword findByLink(String link) {
        return cambioPasswordRepository.findByLink(link);
    }

	@Override
	public void updatePassword(CambioPassword cambioPassword) {
		String password = bCryptPasswordEncoder.encode(cambioPassword.getPassword());
		userRepository.updatePassword(password, cambioPassword.getUsername());
	}

	@Override
	public void delete(CambioPassword cambioPassword) {
		cambioPasswordRepository.delete(cambioPassword);
	}
	
}
