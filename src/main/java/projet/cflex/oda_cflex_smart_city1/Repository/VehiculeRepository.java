package projet.cflex.oda_cflex_smart_city1.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;

public interface VehiculeRepository extends CrudRepository<Vehicule, Integer> {

    @Query("FROM Vehicule WHERE id = ?1")
    public Vehicule findVehiculeById(Integer id);

    @Query("FROM Vehicule ")
    public List<Vehicule> findAllVehicule();
}

