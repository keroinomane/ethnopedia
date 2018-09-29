package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.CambioPassword;

public interface CambioPasswordRepository extends JpaRepository<CambioPassword, Long> {

	@Query(value = "SELECT * FROM cambiopassword WHERE link = ?1", nativeQuery=true)
	CambioPassword findByLink (String link);
}
