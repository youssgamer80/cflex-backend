package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Constituer;


@Repository
public interface ConstituerRepository extends CrudRepository<Constituer, Integer> {

    public Iterable<Constituer> findByStatut(Boolean statut);
	
	@Query("FROM Constituer WHERE statut = ?1")
    public Iterable<Constituer> findByStatutJPQL(Boolean statut);
    
    @Query("FROM Constituer WHERE id = ?1")
    public Constituer findLigne(Integer id);


    // public Constituer findByNom(String nom);	

}