package projet.cflex.oda_cflex_smart_city1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
// import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne_Point_Arret;

@Repository
public interface Ligne_Point_ArretRepository extends CrudRepository<Ligne_Point_Arret, Integer> {

	
	@Query("FROM Ligne_Point_Arret WHERE statut = ?1 ORDER BY id")
    public Iterable<Ligne_Point_Arret> findByStatutJPQL(Boolean statut);
    
    @Query("FROM Ligne_Point_Arret WHERE id_ligne_fk = ?1")
    public List<Ligne_Point_Arret> findByIdligne(Integer idligne);

    @Query("FROM Ligne_Point_Arret WHERE id_point_arret_fk = ?1")
    public Ligne_Point_Arret findByIdpoint(Integer idligne);

    boolean existsLigneByIdPointArretFk(Integer idlignefk);

    // @Query("DELETE FROM Ligne_Point_Arret WHERE id_ligne_fk = ?1")
    // public List<Ligne_Point_Arret> deleteByIdligne(Integer idligne);
    
    
    // public List <Ligne_Point_Arret> deleteByIdligne(Integer idligne);
    // public Ligne_Point_Arret deleteByIdligneFk(Integer idligne);


}