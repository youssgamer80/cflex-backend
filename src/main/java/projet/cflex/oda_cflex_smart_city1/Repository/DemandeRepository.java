package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.cflex.oda_cflex_smart_city1.Model.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {

}