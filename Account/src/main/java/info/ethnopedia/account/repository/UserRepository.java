package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.Ydna;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
    
    @Query(value = "SELECT email FROM usersito WHERE id = ?1", nativeQuery=true)
	public List<String> findEmailById(long id);
    
    @Query(value = "SELECT * FROM usersito WHERE email = ?1", nativeQuery=true)
	public List<User> findByEmail(String email);
}
