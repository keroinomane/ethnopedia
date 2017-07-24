package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.EutestPuri;

public interface EutestPuriRepository extends JpaRepository<EutestPuri, Long> {
	
	EutestPuri findById(long id);
	
	@Query(value = "select distinct(regione) from eutestpuri e", 
			nativeQuery=true
	)
	List<String> getRegioni();

	@Query(value = "select count(*) from eutestpuri e where e.regione = ?1", 
			nativeQuery=true
	)
	int countAutoRegio(String regione);
	
	@Query(value = "SELECT SUM(baltic+easteuro)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaBaltic(String regione);
	
	@Query(value = "SELECT SUM(northcentraleuro)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaNordic(String regione);
	
	@Query(value = "SELECT SUM(middleastern)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaMena(String regione);
	
	@Query(value = "SELECT SUM(eastasian+southasian+siberian)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaAsian(String regione);
	
	@Query(value = "SELECT SUM(westafrican+eastafrican)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaSsa(String regione);
	
	@Query(value = "SELECT SUM(atlantic)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaAtlantic(String regione);
	
	@Query(value = "SELECT SUM(westmed)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaWestmed(String regione);
	
	@Query(value = "SELECT SUM(eastmed)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaEastmed(String regione);
	
	@Query(value = "SELECT SUM(westasian)/COUNT(*) FROM eutestpuri WHERE regione = ?1", 
			nativeQuery=true
	)
	double mediaWestasian(String regione);
}
