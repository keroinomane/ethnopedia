package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.AncientYdna;

public interface AncientYdnaRepository extends JpaRepository<AncientYdna, Long> {
	
	@Query(value = "SELECT * FROM ancientydna a where a.id = ?1", 
    		nativeQuery=true
    )
	public AncientYdna exists(String id);
}
