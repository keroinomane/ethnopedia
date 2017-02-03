package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.UserDati;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
