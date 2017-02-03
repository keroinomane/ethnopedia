package info.ethnopedia.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;

public interface UserDatiRepository extends JpaRepository<UserDati, Long> {
    
    UserDati findById(long id);
    
    @Query(value = "SELECT * FROM user u where UPPER(u.cognome) = UPPER(?1) AND UPPER(u.nome) = UPPER(?2)", 
    		nativeQuery=true
    )
    public UserDati findByCognomeAndNome(String cognome, String nome);
   
}
