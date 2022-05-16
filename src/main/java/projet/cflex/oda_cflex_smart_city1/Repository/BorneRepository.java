package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projet.cflex.oda_cflex_smart_city1.Model.Borne;

public interface BorneRepository extends CrudRepository<Borne, Integer> {

    public Iterable<Borne> findByStatut(Boolean statut);
	
	@Query("FROM Borne WHERE statut = ?1")
    public Iterable<Borne> findByStatutJPQL(Boolean statut);
    
    
    

}