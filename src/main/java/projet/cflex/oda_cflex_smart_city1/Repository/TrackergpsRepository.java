package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TrackergpsRepository extends CrudRepository<Trackergps, Integer> {

	
	@Query("FROM Trackergps WHERE statut = ?1 ORDER BY libelle")
    public Iterable<Trackergps> findByStatutJPQL(Boolean statut);
    
    @Query("FROM Trackergps WHERE id = ?1 AND statut=true")
    public Trackergps findTrackergps(Integer id);


    // @Query("FROM Trackergps WHERE id_vehicule_fk = ?1")
    // public Trackergps findTrackergpsVehicule(Integer id);

    boolean existsTrackergpsByIdVehiculeFk(Vehicule vehicule);

    public Trackergps findByLibelle(String nom);

}


