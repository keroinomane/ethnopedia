package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ethnopedia.account.model.Mtdna;

public interface MtdnaRepository extends JpaRepository<Mtdna, Long> {
    Mtdna findById(long id);
}
