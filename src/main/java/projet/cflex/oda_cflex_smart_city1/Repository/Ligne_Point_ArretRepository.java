package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Ligne_Point_Arret;

@Repository
public interface Ligne_Point_ArretRepository extends CrudRepository<Ligne_Point_Arret, Integer> {

	
	@Query("FROM Ligne_Point_Arret WHERE statut = ?1 ORDER BY id")
    public Iterable<Ligne_Point_Arret> findByStatutJPQL(Boolean statut);
    
    @Query("FROM Ligne_Point_Arret WHERE id = ?1 AND statut=true")
    public Ligne_Point_Arret findLigne(Integer id);


    // public Ligne findByNom(String nom);

}