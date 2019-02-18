package info.ethnopedia.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ethnopedia.account.model.MtdnaBozza;
import info.ethnopedia.account.model.YdnaBozza;
import info.ethnopedia.account.repository.MtdnaBozzaRepository;
import info.ethnopedia.account.repository.YdnaBozzaRepository;

@Service
public class BozzaServiceImpl implements BozzaService {
	
	@Autowired
	private YdnaBozzaRepository yrep;
	@Autowired
	private MtdnaBozzaRepository mrep;
	
	@Override
	public void save(YdnaBozza ydnaBozza) {
		yrep.save(ydnaBozza);
	}

	@Override
	public void save(MtdnaBozza mtdnaBozza) {
		mrep.save(mtdnaBozza);
	}

	@Override
	public List<YdnaBozza> findAllYdna() {
		return yrep.findAll();
	}

	@Override
	public List<MtdnaBozza> findAllMtdna() {
		return mrep.findAll();
	}

	@Override
	public void deleteYdna(Long id) {
		yrep.delete(id);
	}

	@Override
	public void deleteMtdna(Long id) {
		mrep.delete(id);
	}

	@Override
	public YdnaBozza findById(Long id) {
		return yrep.findOne(id);
	}
	
	@Override
	public MtdnaBozza findMtdnaBozzaById(Long id) {
		return mrep.findOne(id);
	}

	@Override
	public List<YdnaBozza> findByUsername(String username) {
		return yrep.findByUsername(username);
	}

	@Override
	public List<MtdnaBozza> findMtdnaBozzaByUsername(String username) {
		return mrep.findByUsername(username);
	}

}
