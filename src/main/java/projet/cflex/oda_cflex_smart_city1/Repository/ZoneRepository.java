package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Zone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

    public Iterable<Zone> findByStatut(Boolean statut);

    @Query("FROM Zone WHERE statut = ?1 ORDER BY libelle")
    public Iterable<Zone> findByStatutJPQL(Boolean statut);

    @Query("FROM Zone WHERE id = ?1")
    public Zone findZone(Integer id);

    boolean existsZoneByLibelle(String libelle);

    @Query(value = "UPDATE zone SET statut=false WHERE zone.id_type_zone_fk =:id", nativeQuery = true)
    void findByIdTypeZoneFkNative(@Param("id") Integer id);

}