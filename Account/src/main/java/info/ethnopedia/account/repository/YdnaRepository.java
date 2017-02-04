package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.Ydna;

public interface YdnaRepository extends JpaRepository<Ydna, Long> {
    Ydna findById(long id);
    
    @Query(value = "SELECT * FROM ydna y where y.cognome = ?1 AND y.nome = ?2", 
    		nativeQuery=true
    )
    public Ydna findByCognomeAndNome(String cognome, String nome);
    
    @Query(value = "SELECT * FROM ydna y where y.cognome = ?1", 
    		nativeQuery=true
    )
    public Ydna findByCognome(String cognome);
    
    @Query(value = "SELECT * FROM ydna y where y.cognome = ?1 AND y.aplogruppo = ?2 AND y.provincia = ?3", 
    		nativeQuery=true
    )
	public Ydna exists(String cognome, String aplogruppo, String provincia);
    
    @Query(value = "select count(*) from ydna y where (y.aplogruppo = 'G' or y.aplogruppo = 'G2a')and y.regione = ?1", 
    		nativeQuery=true
    )
	public int countAploG(String regione);
    
    @Query(value = "select count(*) from ydna y where y.aplogruppo = ?1 and y.regione = ?2", 
    		nativeQuery=true
    )
	public int countAploRegio(String aplo, String regione);
    
    @Query(value = "select count(*) from ydna y where y.regione = ?1", 
    		nativeQuery=true
    )
	public int countRegio(String regione);
    
    @Query(value = "SELECT distinct(regione) FROM ydna", nativeQuery=true)
	public List<String> getRegioni();
    
}
