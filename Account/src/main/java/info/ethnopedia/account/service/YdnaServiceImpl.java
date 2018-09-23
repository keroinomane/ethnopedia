package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.AncientYdna;
import info.ethnopedia.account.model.CladiAplo;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaId;
import info.ethnopedia.account.repository.AncientYdnaRepository;
import info.ethnopedia.account.repository.CladiAploRepository;
import info.ethnopedia.account.repository.YdnaRepository;

@Service
public class YdnaServiceImpl implements YdnaService {
	
	@Autowired
    private YdnaRepository ydnaRepository;
	
	@Autowired
    private AncientYdnaRepository ancientYdnaRepository;
	
	@Autowired
    private CladiAploRepository cladiAploRepository;
	
	@Override
    public void save(Ydna ydna) {
        ydnaRepository.save(ydna);
    }
	
	@Override
    public void save(AncientYdna ancientYdna) {
        ancientYdnaRepository.save(ancientYdna);
    }

	@Override
	public boolean exists(YdnaId ydnaId) {
		return ydnaRepository.exists(ydnaId.getCognome(),ydnaId.getAplogruppo(),ydnaId.getProvincia()) != null;
	}
	
	@Override
	public boolean exists(AncientYdna ancientYdna) {
		return ancientYdnaRepository.exists(ancientYdna.getId()) != null;
	}

	@Override
	public List<String> getCladiByAplo(String aplo) {
		return ydnaRepository.getCladiByAplo(aplo);
	}

	@Override
	public List<String> getSubcladiByClade(String clade) {
		return ydnaRepository.getSubcladiByClade(clade);
	}

	@Override
	public List<CladiAplo> getCladiByAploForAdna(String aplo) {
		return cladiAploRepository.getCladiFromAplogruppo(aplo);
	}
	
	@Override
	public List<AncientYdna> findAllAncientYdna() {
		return ancientYdnaRepository.findAll();
	}

	@Override
	public AncientYdna findAncientYdnaById(String id) {
		return ancientYdnaRepository.exists(id);
	}

	@Override
	public List<Ydna> getPersoneByClade(String clade, Long id) {
		return ydnaRepository.getPersoneByClade(clade, id);
	}

	@Override
	public List<Ydna> getPersoneBySubClade(String subclade, Long id) {
		return ydnaRepository.getPersoneBySubClade(subclade, id);
	}
}
