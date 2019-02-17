package info.ethnopedia.account.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ethnopedia.account.model.Ydna;

public interface YdnaRepository extends JpaRepository<Ydna, Long> {
    Ydna findById(long id);
    
    @Query(value = "SELECT * FROM ydna y where y.cognome = ?1 AND y.nome = ?2", 
    		nativeQuery=true
    )
    public Ydna findByCognomeAndNome(String cognome, String nome);
    
    @Query(value = "SELECT * FROM ydna y where y.cognome = ?1", 
    		nativeQuery=true
    )
    public Ydna findByCognome(String cognome);
    
    @Query(value = "SELECT * FROM ydna y where y.cognome = ?1 AND y.aplogruppo = ?2 AND y.provincia = ?3", 
    		nativeQuery=true
    )
	public Ydna exists(String cognome, String aplogruppo, String provincia);
    
    @Query(value = "select count(*) from ydna y where (y.aplogruppo = 'G' or y.aplogruppo = 'G2a')and y.regione = ?1", 
    		nativeQuery=true
    )
	public int countAploG(String regione);
    
    @Query(value = "select count(*) from ydna y where y.aplogruppo = ?1 and y.regione = ?2", 
    		nativeQuery=true
    )
	public int countAploRegio(String aplo, String regione);
    
    @Query(value = "select count(*) from ydna y where (y.aplogruppo = 'G' or y.aplogruppo = 'G2a')and y.provincia = ?1", 
    		nativeQuery=true
    )
	public int countAploGProv(String prov);
    
    @Query(value = "select count(*) from ydna y where y.aplogruppo = ?1 and y.provincia = ?2", 
    		nativeQuery=true
    )
	public int countAploProv(String aplo, String prov);
    
    @Query(value = "select count(*) from ydna y where y.regione = ?1", 
    		nativeQuery=true
    )
	public int countRegio(String regione);
    
    @Query(value = "select count(*) from ydna y where y.provincia = ?1", 
    		nativeQuery=true
    )
	public int countProv(String prov);
    
    @Query(value = "SELECT distinct(regione) FROM ydna", nativeQuery=true)
	public List<String> getRegioni();
    
    @Query(value = "SELECT provincia FROM ydna GROUP BY provincia HAVING COUNT(provincia) > 9", nativeQuery=true)
    public List<String> getProvinceConPiuCampioni();
    
    @Query(value = "SELECT distinct(clade) FROM ydna WHERE aplogruppo = ?1 AND clade IS NOT NULL", nativeQuery=true)
	public List<String> getCladiByAplo(String aplo);
    
    @Query(value = "SELECT distinct(subclade) FROM ydna WHERE clade = ?1 AND subclade IS NOT NULL", nativeQuery=true)
	public List<String> getSubcladiByClade(String clade);
    
    @Query(value = "select count(*) from ydna y where y.clade = ?1 and y.regione = ?2", 
    		nativeQuery=true
    )
	public int countCladeRegio(String clade, String regione);
    
    @Query(value = "select count(*) from ydna y where y.subclade = ?1 and y.regione = ?2", 
    		nativeQuery=true
    )
	public int countSubcladeRegio(String subclade, String regione);
    
    @Query(value = "SELECT y.* FROM ydna y join usersito u on y.id=u.id WHERE y.clade = ?1 and y.id <> ?2 group by y.id", nativeQuery=true)
	public List<Ydna> getPersoneByClade(String clade, Long id);
    
    @Query(value = "SELECT y.* FROM ydna y join usersito u on y.id=u.id WHERE y.subclade = ?1 and y.id <> ?2 group by y.id", nativeQuery=true)
	public List<Ydna> getPersoneBySubClade(String subclade, Long id);
    
    @Query(value = "SELECT * FROM ydna y where y.cognome = ?1", nativeQuery=true)
    public List<Ydna> getPersoneByCognome(String cognome);
    
}
