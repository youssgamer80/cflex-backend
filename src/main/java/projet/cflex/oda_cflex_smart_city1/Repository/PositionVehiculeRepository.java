package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import projet.cflex.oda_cflex_smart_city1.Model.PositionVehicule;

import java.util.Optional;

public interface PositionVehiculeRepository extends MongoRepository<PositionVehicule, Long> {
    @Query("{'tracker':?0}")
    Optional<PositionVehicule> findPositionVehiculeBy(String trackerposvehicule);
}
