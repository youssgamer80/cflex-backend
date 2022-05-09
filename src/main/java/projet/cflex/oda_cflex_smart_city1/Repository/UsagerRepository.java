package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projet.cflex.oda_cflex_smart_city1.Model.Usager;


public interface UsagerRepository extends CrudRepository<Usager, Integer> {

    public Iterable<Usager> findByStatut(Boolean statut);
	
	@Query("FROM Usager WHERE statut = ?1")
    public Iterable<Usager> findByStatutJPQL(Boolean statut);	

}