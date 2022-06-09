package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.PointArret;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PointArretRepository extends JpaRepository<PointArret, Integer> {

   public Iterable<PointArret> findByStatut(Boolean statut);
	
	@Query("FROM PointArret WHERE statut = ?1 ORDER BY nom")
    public List<PointArret> findByStatutJPQL(Boolean statut);

   @Query(value = "SELECT * FROM point_arret INNER JOIN zone ON point_arret.id_zone_fk = zone.id WHERE zone.libelle = :libelle", nativeQuery = true)
   public Iterable<PointArret> findByLibelleNative(@Param("libelle") String libelle);

   @Query(value="SELECT * FROM point_arret WHERE nom=:nom AND statut = 1",nativeQuery=true)
   public Iterable<PointArret>  findByNomNative(@Param("nom") String nom);


   @Query(value="SELECT * FROM point_arret WHERE id_zone_fk=:idZoneFk",nativeQuery=true)
   public Iterable<PointArret> findByIdZoneFkNative(@Param("idZoneFk") Integer idZoneFk);
   
}