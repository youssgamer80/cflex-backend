package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {

    
}