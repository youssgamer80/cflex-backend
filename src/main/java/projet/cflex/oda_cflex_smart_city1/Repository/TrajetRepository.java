package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.cflex.oda_cflex_smart_city1.Model.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Integer> {

    public Iterable<Trajet> findByStatut(Boolean statut);
	
	@Query("FROM Trajet WHERE statut = ?1")
    public Iterable<Trajet> findByStatutJPQL(Boolean statut);

    
    @Query(value="SELECT * FROM trajet WHERE depart = :depart AND destination = :destination", nativeQuery =true)
    public Iterable<Trajet> findByDepartAndDestination(@Param("depart") String depart,@Param("destination") String destination);

}