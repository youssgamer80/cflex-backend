package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.TypeZone;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeZoneRepository extends CrudRepository<TypeZone, Integer> {

    @Query("FROM TypeZone WHERE statut = ?1")
    public Iterable<TypeZone> findByStatutJPQL(Boolean name);
}