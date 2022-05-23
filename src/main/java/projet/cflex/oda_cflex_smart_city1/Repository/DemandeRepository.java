package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Demande;
@Repository
public interface DemandeRepository extends CrudRepository<Demande, Integer> {

    public Iterable<Demande> findByStatut(Boolean statut);

    @Query("FROM Demande WHERE statut = ?1")
    public Iterable<Demande> findByStatutJPQL(Boolean statut);
}