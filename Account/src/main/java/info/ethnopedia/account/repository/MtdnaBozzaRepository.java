package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.MtdnaBozza;

public interface MtdnaBozzaRepository extends JpaRepository<MtdnaBozza, Long> {

	@Query(value = "SELECT * FROM mtdnabozza WHERE username = ?1", nativeQuery=true)
	public List<MtdnaBozza> findByUsername(String username);
	
}
