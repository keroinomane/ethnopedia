package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.Partecipante;

public interface PartecipanteRepository extends JpaRepository<Partecipante, Long> {

	@Query(value = "SELECT * FROM partecipanti p where p.esito = 'IN CORSO'", 
    		nativeQuery=true
    )
    public Partecipante findPartecipanteInCorso();
}
