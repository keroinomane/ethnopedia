package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.YdnaBozza;

public interface YdnaBozzaRepository extends JpaRepository<YdnaBozza, Long> {
	
	@Query(value = "SELECT * FROM ydnabozza WHERE username = ?1", nativeQuery=true)
	public List<YdnaBozza> findByUsername(String username);
	
}
