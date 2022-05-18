package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Itineraire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItineraireRepository extends JpaRepository<Itineraire, Integer> {

    public Iterable<Itineraire> findByStatut(Boolean statut);
	
	@Query("FROM Itineraire WHERE statut = ?1")
    public Iterable<Itineraire> findByStatutJPQL(Boolean statut);

}