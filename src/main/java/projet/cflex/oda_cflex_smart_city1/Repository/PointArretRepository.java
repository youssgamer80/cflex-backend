package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.PointArret;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;


public interface PointArretRepository extends JpaRepository<PointArret, Integer> {

    public Iterable<PointArret> findByStatut(Boolean statut);
	
	@Query("FROM PointArret WHERE statut = ?1")
    public Iterable<PointArret> findByStatutJPQL(Boolean statut);

}