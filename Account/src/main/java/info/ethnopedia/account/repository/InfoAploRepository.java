package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.InfoAplo;

public interface InfoAploRepository extends JpaRepository<InfoAplo, Long> {
	
	@Query(value = "SELECT contenuto FROM infoaplo where aplogruppo = ?1", nativeQuery=true)
	String getContent(String aplo);

}
