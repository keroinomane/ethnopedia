package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ethnopedia.account.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
