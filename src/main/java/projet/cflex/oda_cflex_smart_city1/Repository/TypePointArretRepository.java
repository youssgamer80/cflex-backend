package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projet.cflex.oda_cflex_smart_city1.Model.TypePointArret;

public interface TypePointArretRepository extends  CrudRepository<TypePointArret, Integer>{
    public  Iterable<TypePointArret> findByStatut(Boolean statut);
    @Query("FROM TypePointArret WHERE statut = ?1 ORDER BY type_point_arret")
   public Iterable<TypePointArret> findByStatutJPQL(Boolean statut);
    
}
