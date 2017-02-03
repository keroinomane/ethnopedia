package info.ethnopedia.account.repository;

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
}
