package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Demande;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {
    Optional<Demande> findByDate(Instant date);
}