package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Ligne;

@Repository
public interface LigneRepository extends CrudRepository<Ligne, Integer> {

	
	@Query("FROM Ligne WHERE statut = ?1 ORDER BY nom")
    public Iterable<Ligne> findByStatutJPQL(Boolean statut);
    
    @Query("FROM Ligne WHERE id = ?1 AND statut=true")
    public Ligne findLigne(Integer id);

    boolean existsLigneByNom(String nom);
    
    public Ligne findByNom(String nom);

}