package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.repository.EutestRepository;

@Service
public class EutestServiceImpl implements EutestService {
	
	@Autowired
	private EutestRepository eutestRepository;
	 
	@Override
	public Eutest findById(long id) {
		return eutestRepository.findById(id);
	}

	@Override
	public void save(Eutest eutest) {
		eutestRepository.save(eutest);
	}
	
}
