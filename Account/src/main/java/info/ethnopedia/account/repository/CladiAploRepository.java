package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.CladiAplo;

public interface CladiAploRepository extends JpaRepository<CladiAplo, Long> {
	
	@Query(value = "SELECT * FROM cladiaplo WHERE aplogruppo = ?1", nativeQuery=true)
	List<CladiAplo> getCladiFromAplogruppo (String aplogruppo);

}
