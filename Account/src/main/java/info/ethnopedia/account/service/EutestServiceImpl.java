package info.ethnopedia.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.EutestPlebe;
import info.ethnopedia.account.model.EutestPuri;
import info.ethnopedia.account.repository.EutestPlebeRepository;
import info.ethnopedia.account.repository.EutestPuriRepository;
import info.ethnopedia.account.repository.EutestRepository;

@Service
public class EutestServiceImpl implements EutestService {
	
	@Autowired
	private EutestRepository eutestRepository;
	
	@Autowired
	private EutestPlebeRepository eutestPlebeRepository;
	
	@Autowired
	private EutestPuriRepository eutestPuriRepository;
	 
	@Override
	public EutestPlebe findById(long id) {
		return eutestPlebeRepository.findById(id);
	}

	@Override
	public void save(Eutest eutest) {
		eutestRepository.save(eutest);
	}
	
	@Override
	public void save(EutestPlebe eutestPlebe) {
		eutestPlebeRepository.save(eutestPlebe);
	}

	@Override
	public EutestPuri findPuroById(long id) {
		return eutestPuriRepository.findById(id);
	}
	
}
