package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ethnopedia.account.model.CambioPassword;

public interface CambioPasswordRepository extends JpaRepository<CambioPassword, Long> {

}
