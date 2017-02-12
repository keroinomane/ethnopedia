package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaId;
import info.ethnopedia.account.repository.YdnaRepository;

@Service
public class YdnaServiceImpl implements YdnaService {
	@Autowired
    private YdnaRepository ydnaRepository;
	
	@Override
    public void save(Ydna ydna) {
        ydnaRepository.save(ydna);
    }

	@Override
	public boolean exists(YdnaId ydnaId) {
		return ydnaRepository.exists(ydnaId.getCognome(),ydnaId.getAplogruppo(),ydnaId.getProvincia()) != null;
	}

	@Override
	public List<String> getCladiByAplo(String aplo) {
		return ydnaRepository.getCladiByAplo(aplo);
	}

	@Override
	public List<String> getSubcladiByClade(String clade) {
		return ydnaRepository.getSubcladiByClade(clade);
	}
}
