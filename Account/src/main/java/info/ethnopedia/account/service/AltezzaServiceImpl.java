package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Altezza;
import info.ethnopedia.account.repository.AltezzaRepository;

@Service
public class AltezzaServiceImpl implements AltezzaService {

	@Autowired
    private AltezzaRepository altezzaRepository;
    
	@Override
	public Altezza findById(long id) {
		return altezzaRepository.findById(id);
	}

	@Override
	public void save(Altezza altezza) {
		altezzaRepository.save(altezza);
	}

	@Override
	public List<Integer> getAltezze() {
		return altezzaRepository.getAltezze();
	}

	@Override
	public List<String> getRegioni() {
		return altezzaRepository.getRegioni();
	}
	
}