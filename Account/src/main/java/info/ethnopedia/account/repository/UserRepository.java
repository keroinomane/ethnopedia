package info.ethnopedia.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import info.ethnopedia.account.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
    
    @Query(value = "SELECT email FROM usersito WHERE id = ?1", nativeQuery=true)
	public List<String> findEmailById(long id);
    
    @Query(value = "SELECT * FROM usersito WHERE email = ?1", nativeQuery=true)
	public List<User> findByEmail(String email);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE usersito SET password = ?1 WHERE username = ?2", nativeQuery=true)
	public void updatePassword(String password, String username);
}
