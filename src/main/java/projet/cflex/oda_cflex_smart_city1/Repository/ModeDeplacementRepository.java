package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.ModeDeplacement;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ModeDeplacementRepository extends CrudRepository<ModeDeplacement, Integer> {
    public  Iterable<ModeDeplacement> findByStatut(Boolean statut);
    @Query("FROM ModeDeplacement WHERE statut = ?1")
   public Iterable<ModeDeplacement> findByStatutJPQL(Boolean statut);

   public Iterable<ModeDeplacement> findByModeDeplacement(String modeDeplacement);

    

}