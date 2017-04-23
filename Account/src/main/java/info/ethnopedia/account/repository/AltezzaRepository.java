package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.Altezza;

public interface AltezzaRepository extends JpaRepository<Altezza, Long> {
	
	Altezza findById(long id);
    
    @Query(value = "SELECT altezza FROM altezza", nativeQuery=true)
	public List<Integer> getAltezze();
    
    @Query(value = "SELECT distinct(regione) FROM altezza ORDER BY regione", nativeQuery=true)
	public List<String> getRegioni();
    
    @Query(value = "select sum(altezza) from altezza where regione = ?1", 
    		nativeQuery=true
    )
	public int sumAltezzeRegio(String regione);
    
    @Query(value = "select count(*) from altezza where regione = ?1", 
    		nativeQuery=true
    )
	public int countRegio(String regione);
}
