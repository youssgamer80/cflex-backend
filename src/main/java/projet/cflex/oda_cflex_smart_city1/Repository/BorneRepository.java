package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Borne;

@Repository
public interface BorneRepository extends CrudRepository<Borne, Integer> {

	
	@Query("FROM Borne WHERE statut = ?1 ORDER BY libelle")
    public Iterable<Borne> findByStatutJPQL(Boolean statut);
    
    @Query("FROM Borne WHERE id = ?1 AND statut=true")
    public Borne findBorne(Integer id);


    public Borne findByLibelle(String nom);

}