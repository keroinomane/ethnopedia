package info.ethnopedia.account.service;

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
}
