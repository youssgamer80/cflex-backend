package projet.cflex.oda_cflex_smart_city1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.LignePointArret;

@Repository
public interface LignePointArretRepository extends CrudRepository<LignePointArret, Integer> {
    

    @Query("FROM LignePointArret WHERE statut = ?1 ORDER BY id")
    public Iterable<LignePointArret> findByStatutJPQL(Boolean statut);
    
    @Query("FROM LignePointArret WHERE id_ligne_fk = ?1")
    public List<LignePointArret> findByIdligne(Integer idligne);

    @Query("FROM LignePointArret WHERE id = ?1")
    public LignePointArret findByIdlignePointArrêt(Integer idligne);


    @Query("UPDATE LignePointArret SET statut = true WHERE id_ligne_fk = :idligne AND id_point_arret_fk = :idpoint AND id = :id")
    public LignePointArret UpdatlignePointArret(@Param("idligne") int idligne, @Param("idpoint") int idpoint);

    
    // public LignePointArret deleteByIdligneFk(Integer idligne);

        // @Modifying(clearAutomatically = true)
    // @Query("UPDATE Ligne_Point_Arret SET statut = true WHERE id_ligne_fk = :idligne AND id_point_arret_fk = :idpoint AND id =14")
    // int updateAddress(@Param("idligne") int idligne, @Param("idpoint") int idpoint);

    
    // @Query("FROM Ligne_Point_Arret WHERE id_point_arret_fk = ?1")
    // public Ligne_Point_Arret findByIdpoint(Integer idligne);

    // @Query("FROM Ligne_Point_Arret WHERE id_ligne_fk AND id_point_arret_fk = ?1")
    // boolean existsLigneByIdLigneAndIdPointArretFk(Ligne idligne, PointArret idlignefk);

    // @Query("DELETE FROM Ligne_Point_Arret WHERE id_ligne_fk = ?1")
    // public List<Ligne_Point_Arret> deleteByIdligne(Integer idligne);
    
    
    // public List <Ligne_Point_Arret> deleteByIdligne(Integer idligne);
    // public Ligne_Point_Arret deleteByIdligneFk(Integer idligne);


}