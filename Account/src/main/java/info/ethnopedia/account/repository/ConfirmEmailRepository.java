package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.ConfirmEmail;

public interface ConfirmEmailRepository extends JpaRepository<ConfirmEmail, Long> {

	@Query(value = "SELECT * FROM confirmemail WHERE link = ?1", nativeQuery=true)
	ConfirmEmail findByLink (String link);
}
