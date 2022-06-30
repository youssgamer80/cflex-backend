package projet.cflex.oda_cflex_smart_city1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.LignePointArret;

@Repository
public interface LignePointArretRepository extends CrudRepository<LignePointArret, Integer> {

	
	@Query("FROM LignePointArret WHERE statut = ?1 ORDER BY id")
    public Iterable<LignePointArret> findByStatutJPQL(Boolean statut);
    
    @Query("FROM LignePointArret WHERE id_ligne_fk = ?1")
    public List<LignePointArret> findByIdligne(Integer idligne);

    
    // public Ligne_Point_Arret deleteByIdligneFk(Integer idligne);


}