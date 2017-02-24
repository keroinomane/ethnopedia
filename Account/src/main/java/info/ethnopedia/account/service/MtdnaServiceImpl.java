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
}
