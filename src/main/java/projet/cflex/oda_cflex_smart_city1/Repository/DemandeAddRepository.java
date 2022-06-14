package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.DemandeAdd;

@Repository
public interface DemandeAddRepository extends CrudRepository<DemandeAdd, Integer> {

    public Iterable<DemandeAdd> findByStatut(Boolean statut);

    @Query("FROM Demande WHERE statut = ?1")
    public Iterable<DemandeAdd> findByStatutJPQL(Boolean statut);
}
