package projet.cflex.oda_cflex_smart_city1.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;

public interface TrackergpsRepository extends CrudRepository<Trackergps, Integer> {

    public Iterable<Trackergps> findByStatut(Boolean statut);
	
	@Query("FROM Trackergps WHERE statut = ?1")
    public Iterable<Trackergps> findByStatutJPQL(Boolean statut);	

}