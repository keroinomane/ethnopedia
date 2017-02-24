package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.Mtdna;

public interface MtdnaRepository extends JpaRepository<Mtdna, Long> {
    Mtdna findById(long id);
    
    @Query(value = "SELECT distinct(aplogruppo) FROM mtdna ORDER BY aplogruppo", nativeQuery=true)
	public List<String> getAplogruppi();
    
    @Query(value = "SELECT distinct(macroregione) FROM mtdna ORDER BY macroregione", nativeQuery=true)
	public List<String> getMacroregioni();
    
    @Query(value = "select count(*) from mtdna where aplogruppo = ?1 and macroregione = ?2", 
    		nativeQuery=true
    )
	public int countAploMtdnaMacroRegio(String aplo, String macroregione);
    
    @Query(value = "select count(*) from mtdna where macroregione = ?1", 
    		nativeQuery=true
    )
	public int countMacroRegio(String macroregione);
}
