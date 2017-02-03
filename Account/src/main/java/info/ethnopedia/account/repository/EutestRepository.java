package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ethnopedia.account.model.Eutest;

public interface EutestRepository extends JpaRepository<Eutest, Long> {
	Eutest findById(long id);
}
