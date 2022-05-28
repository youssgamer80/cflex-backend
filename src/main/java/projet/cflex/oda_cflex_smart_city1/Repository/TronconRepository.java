package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Troncon;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TronconRepository extends CrudRepository<Troncon, Integer> {

    public Iterable<Troncon> findByStatut(Boolean statut);
    @Query("FROM Troncon WHERE statut = ?1")
    public Iterable<Troncon> findByStatutJPQL(Boolean statut);

    public Iterable<Troncon> findByNom(String nom);
}