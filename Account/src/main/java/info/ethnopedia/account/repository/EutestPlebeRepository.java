package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ethnopedia.account.model.EutestPlebe;

public interface EutestPlebeRepository extends JpaRepository<EutestPlebe, Long> {
	EutestPlebe findById(long id);

}
