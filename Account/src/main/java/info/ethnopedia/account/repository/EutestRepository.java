package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.Eutest;

public interface EutestRepository extends JpaRepository<Eutest, Long> {
	Eutest findById(long id);
	
	@Query(value = "select count(*) from eutest e where e.macroregione = ?1", 
			nativeQuery=true
	)
	int countAutoMacroregio(String macro);
	
	@Query(value = "select distinct(macroregione) from eutest e", 
			nativeQuery=true
	)
	List<String> getMacroregioni();
	
	@Query(value = "SELECT SUM(baltic+easteuro)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaBaltic(String macro);
	
	@Query(value = "SELECT SUM(northcentraleuro)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaNordic(String macro);
	
	@Query(value = "SELECT SUM(middleastern)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaMena(String macro);
	
	@Query(value = "SELECT SUM(eastasian+southasian+siberian)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaAsian(String macro);
	
	@Query(value = "SELECT SUM(westafrican+eastafrican)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaSsa(String macro);
	
	@Query(value = "SELECT SUM(atlantic)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaAtlantic(String mac);
	
	@Query(value = "SELECT SUM(westmed)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaWestmed(String mac);
	
	@Query(value = "SELECT SUM(eastmed)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaEastmed(String mac);
	
	@Query(value = "SELECT SUM(westasian)/COUNT(*) FROM eutest WHERE macroregione = ?1", 
			nativeQuery=true
	)
	double mediaWestasian(String mac);
	
	
}
