package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.TableYdna;
import info.ethnopedia.account.repository.TableYdnaRepository;
import info.ethnopedia.account.repository.YdnaRepository;

@Service
public class StatisticheServiceImpl implements StatisticheService {
	
	@Autowired
	private TableYdnaRepository tyrep;
	
	@Autowired
	private YdnaRepository yrep;

	@Override
	public void deleteAllTableYdna() {
		tyrep.deleteAll();
	}

	@Override
	public List<String> getRegioni() {
		return yrep.getRegioni();
	}

	@Override
	public int countAploG(String regio) {
		return yrep.countAploG(regio);
	}

	@Override
	public int countAploRegio(String aplo, String regio) {
		return yrep.countAploRegio(aplo, regio);
	}

	@Override
	public int countRegio(String regio) {
		return yrep.countRegio(regio);
	}

	@Override
	public void save(TableYdna tableYdna) {
		tyrep.save(tableYdna);
	}

	@Override
	public List<TableYdna> findAll() {
		return tyrep.findAll();
	}

}
