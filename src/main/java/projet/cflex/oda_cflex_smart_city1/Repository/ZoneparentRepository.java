package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Zoneparent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ZoneparentRepository extends JpaRepository<Zoneparent, Integer> {

    public Iterable<Zoneparent> findByStatut(Boolean statut);

    @Query("FROM Zoneparent WHERE statut = ?1")
    public Iterable<Zoneparent> findByStatutJPQL(Boolean statut);
}