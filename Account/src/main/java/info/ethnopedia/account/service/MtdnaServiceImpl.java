package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Mtdna;
import info.ethnopedia.account.repository.MtdnaRepository;

@Service
public class MtdnaServiceImpl implements MtdnaService {
	
    @Autowired
    private MtdnaRepository mtdnaRepository;
    
	@Override
	public Mtdna findById(long id) {
		return mtdnaRepository.findById(id);
	}

	@Override
	public void save(Mtdna mtdna) {
		mtdnaRepository.save(mtdna);
	}

	@Override
	public List<String> getAplogruppi() {
		return mtdnaRepository.getAplogruppi();
	}
	
	@Override
	public List<String> getMacroregioni() {
		return mtdnaRepository.getMacroregioni();
	}
	
	@Override
	public List<String> getRegioni() {
		return mtdnaRepository.getRegioni();
	}

	@Override
	public List<Mtdna> getPersoneByClade(String clade, Long id) {
		return mtdnaRepository.getPersoneByClade(clade, id);
	}

	@Override
	public List<Mtdna> getPersoneByAplogruppo(String aplogruppo, Long id) {
		return mtdnaRepository.getPersoneByAplogruppo(aplogruppo, id);
	}
	
	@Override
	public List<Mtdna> getPersoneByCognome(String cognome) {
		return mtdnaRepository.getPersoneByCognome(cognome);
	}
}
