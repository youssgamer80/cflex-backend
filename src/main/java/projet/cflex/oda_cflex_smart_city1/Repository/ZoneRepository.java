package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Zone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

    public Iterable<Zone> findByStatut(Boolean statut);

    @Query("FROM Zone WHERE statut = ?1")
    public Iterable<Zone> findByStatutJPQL(Boolean statut);
}